package com.generatortest.generatortest;

import com.generatortest.generatortest.data.Plant;
import com.generatortest.generatortest.data.PlantRepository;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)

class PlantRepositoryIntegrationTest {

    @Autowired
    PlantRepository plantRepository;

    @Test
    public void testGetPlantSuccess() {
        Plant plant = plantRepository.findById(5L).get();
        Assertions.assertNotNull(plant);
        Assertions.assertNotNull(plant.getSequenceNumber());
        Assertions.assertEquals(5, plant.getSequenceNumber());
    }

    @Test
    public void testGetPlantFail() {
        Plant plant = null;
        try {
            plant = plantRepository.findById(-5L).get();
        } catch (Exception e) {
        }
        Assertions.assertNull(plant);
    }

    @Test
    public void testGetPlantByLocationSuccess() {
        List<Plant> plants = plantRepository.findByPlantLocationCode("AK");
        Assertions.assertNotNull(plants);
        Assertions.assertEquals(plants.size(), 769);
    }

    @Test
    public void testGetPlantByLocationFail() {
        List<Plant> plants = plantRepository.findByPlantLocationCode("AK9");
        Assertions.assertNotNull(plants);
        Assertions.assertEquals(plants.size(), 0);

    }

    @Test
    public void testGetPlantByLocationSuccess_paginated() {
        Pageable paging = PageRequest.of(0, 20);
        List<Plant> plants = plantRepository.findByPlantLocationCode("AK", paging);
        Assertions.assertNotNull(plants);
        Assertions.assertEquals(plants.size(), 20);
    }

    @Test
    public void testGetPlantByLocationFail_paginated() {
        List<Plant> plants = null;
        try {
            Pageable paging = PageRequest.of(-8, 20);
            plants = plantRepository.findByPlantLocationCode("AK", paging);
        } catch (Exception e) {
        }
        Assertions.assertNull(plants);

    }

    @Test
    public void testGetTotalGenoutputPerLocationSuccess() {
        BigDecimal totalGenoutputPerLocation = plantRepository.getTotalGenoutputPerLocation("AK");
        Assertions.assertNotNull(totalGenoutputPerLocation);
        Assertions.assertEquals(totalGenoutputPerLocation.floatValue(), 6068262.0);
    }
    
     @Test
    public void testGetTotalGenoutputPerLocationFailure() {
        BigDecimal totalGenoutputPerLocation = plantRepository.getTotalGenoutputPerLocation("AKR");
        Assertions.assertNull(totalGenoutputPerLocation);
    }

}
