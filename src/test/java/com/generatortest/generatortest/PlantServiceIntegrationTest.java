package com.generatortest.generatortest;

import com.generatortest.generatortest.data.Plant;
import com.generatortest.generatortest.service.PlantService;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class PlantServiceIntegrationTest {

    @Autowired
    PlantService plantService;

    @Test
    public void testGetPlantSuccess() {
        CompletableFuture<Plant> plant = plantService.getPlant(5L);
        Plant plantData = null;
        try {
            plantData = plant.get();
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(PlantServiceIntegrationTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        Assertions.assertNotNull(plantData);
        Assertions.assertEquals(5, plantData.getSequenceNumber());
    }

    @Test
    public void testGetPlantFail() {
        CompletableFuture<Plant> plant = plantService.getPlant(-5L);
        //  PlantNotFoundException notFoundException = new PlantNotFoundException(-5L);
        //  Assertions.assertTrue(plant.completeExceptionally(notFoundException));
        Plant plantData = null;
        try {
            plantData = plant.get();
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(PlantServiceIntegrationTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        Assertions.assertNull(plantData);
    }

    @Test
    public void testGetPlantByLocationSuccess() {
        CompletableFuture<List<Plant>> plants = plantService.getPlants("AK", null, null, null, 0, 3);
        List<Plant> plantsData = null;
        try {
            plantsData = plants.get();
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(PlantServiceIntegrationTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        Assertions.assertNotNull(plantsData);
        Assertions.assertEquals(3, plantsData.size());
    }

    @Test
    public void testGetPlantByLocationFail() {

        CompletableFuture<List<Plant>> plants = plantService.getPlants("AK9", null, null, null, 0, 3);
//        PlantNotFoundException notFoundException = new PlantNotFoundException();
//        Assertions.assertTrue(plants.completeExceptionally(notFoundException));
        List<Plant> plantsData = null;
        try {
            plantsData = plants.get();
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(PlantServiceIntegrationTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        Assertions.assertEquals(0, plantsData.size());
    }

    @Test
    public void testGetTopPlantsSuccessAsc() {

        CompletableFuture<List<Plant>> plants = plantService.getPlants(null, 5, null, "asc", null, null);
        List<Plant> plantsData = null;
        try {
            plantsData = plants.get();
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(PlantServiceIntegrationTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        Assertions.assertNotNull(plantsData);
        Assertions.assertEquals(5, plantsData.size());
    }

    @Test
    public void testGetTopPlantsSuccessDesc() {

        CompletableFuture<List<Plant>> plants = plantService.getPlants(null, 5, null, "desc", null, null);
        List<Plant> plantsData = null;
        try {
            plantsData = plants.get();
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(PlantServiceIntegrationTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        Assertions.assertNotNull(plantsData);
        Assertions.assertEquals(5, plantsData.size());
    }



    @Test
    public void testGetBottomPlantsSuccessDesc() {

        CompletableFuture<List<Plant>> plants = plantService.getPlants(null, null, 5, "desc", null, null);
        List<Plant> plantsData = null;
        try {
            plantsData = plants.get();
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(PlantServiceIntegrationTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        Assertions.assertNotNull(plantsData);
        Assertions.assertEquals(5, plantsData.size());
    }


    @Test
    public void testGetBottomPlantsSuccessAsc() {
        CompletableFuture<List<Plant>> plants = plantService.getPlants(null, null, 5, "asc", null, null);
        List<Plant> plantsData = null;
        try {
            plantsData = plants.get();
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(PlantServiceIntegrationTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        Assertions.assertNotNull(plantsData);
        Assertions.assertEquals(5, plantsData.size());
    }



}
