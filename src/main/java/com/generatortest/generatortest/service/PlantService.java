/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.generatortest.generatortest.service;

import com.generatortest.generatortest.data.Plant;
import com.generatortest.generatortest.data.PlantRepository;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bsystems4
 */
@EnableCaching
@CacheConfig(cacheNames = "plant")
@Service
public class PlantService {

    private final PlantRepository plantRepository;

    public PlantService(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    @Cacheable
    @Async
    public CompletableFuture<List<Plant>> getPlants(
            String locationCode,
            Integer top,
            Integer bottom,
            String sort,
            Integer page,
            Integer size
    ) {
        List<Plant> listOfPlants = null;
        if (locationCode != null) {
            if (page != null && size != null) {
                Pageable paging = PageRequest.of(page, size);
                listOfPlants = this.plantRepository.findByPlantLocationCode(locationCode, paging);
            } else {
                listOfPlants = this.plantRepository.findByPlantLocationCode(locationCode);
            }
        } else if (top != null) {
            List<Plant> sortedPlants = this.plantRepository.findAll(Sort.by(Sort.Direction.DESC, "generatorAnnualNetGeneration"));
            listOfPlants = rankPlants(sortedPlants, top, sort);
        } else if (bottom != null) {
            List<Plant> sortedPlants = this.plantRepository.findAll(Sort.by(Sort.Direction.ASC, "generatorAnnualNetGeneration"));
            listOfPlants = rankPlants(sortedPlants, bottom, sort);
        } else {
            listOfPlants = (List<Plant>) this.plantRepository.findAll();
        }
        return CompletableFuture.completedFuture(addPercentage(listOfPlants));
    }

    private List<Plant> rankPlants(List<Plant> sortedPlants, int numberOfPlants, String sort) {
        List<Plant> rankedPlants = new ArrayList<>();
        if (sort.equalsIgnoreCase("ASC")) {
            for (int i = 0; i < numberOfPlants; i++) {
                rankedPlants.add(sortedPlants.get(i));
            }
        } else {
            for (int i = numberOfPlants - 1; i >= 0; i--) {
                rankedPlants.add(sortedPlants.get(i));
            }
        }
        return rankedPlants;
    }

    @Cacheable
    @Async
    public CompletableFuture<Plant> getPlant(Long plantId) {
        Plant plant = this.plantRepository.findById(plantId).get();
        return CompletableFuture.completedFuture(addPercentage(plant));
    }

    private Plant addPercentage(Plant plant) {
        plant.setPercentageGenerationPerLocation(
                calcPercentage(plant.getGeneratorAnnualNetGeneration(),
                        this.plantRepository.getTotalGenoutputPerLocation(plant.getPlantLocationCode())
                ) + "%"
        );
        return plant;
    }

    private List<Plant> addPercentage(List<Plant> plants) {
        plants.forEach((Plant plant) -> {
            plant.setPercentageGenerationPerLocation(
                    calcPercentage(plant.getGeneratorAnnualNetGeneration(),
                            this.plantRepository.getTotalGenoutputPerLocation(plant.getPlantLocationCode())
                    ) + "%"
            );
        });
        return plants;
    }

    private String calcPercentage(BigDecimal generatorAnnualNetGeneration, BigDecimal totalGenAnnualoutputPerLocation) {
        float genAnnualNet = generatorAnnualNetGeneration.floatValue();
        float totalGenPerLocation = totalGenAnnualoutputPerLocation.floatValue();
        if (totalGenPerLocation == 0 || genAnnualNet == 0) {
            return "0.0000";
        } else {
            return new DecimalFormat("##0.0000").format(genAnnualNet * 100 / totalGenPerLocation);
        }
    }

}
