/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.generatortest.generatortest.controller;

import com.generatortest.generatortest.data.Plant;
import com.generatortest.generatortest.service.PlantService;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Bsystems4
 */
@RestController
@RequestMapping("/api")

public class PlantController {

    private final PlantService plantService;
    private final PlantModelAssembler assembler;

    public PlantController(PlantService plantService, PlantModelAssembler assembler) {
        this.plantService = plantService;
        this.assembler = assembler;
    }

    @RequestMapping(value = "/plants", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity getPlants(
            @RequestParam(value = "location", required = false) String locationCode,
            @RequestParam(value = "top", required = false) Integer top,
            @RequestParam(value = "bottom", required = false) Integer bottom,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "size", required = false) Integer size
    ) throws InterruptedException {
        CompletableFuture<List<Plant>> plants = plantService.getPlants(locationCode, top, bottom, sort, page, size);
        try {
            return ResponseEntity.ok().body(plants.get());
        } catch (ExecutionException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Zero records retrieved");
        }

    }

    @RequestMapping(value = "/plants/{plantId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity getPlant(@PathVariable Long plantId) {
        CompletableFuture<Plant> plant = plantService.getPlant(plantId);
        try {
            return ResponseEntity.ok().body(plant.get());
        } catch (InterruptedException | ExecutionException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Could not find plant with id " + plantId);
        }

    }

}
