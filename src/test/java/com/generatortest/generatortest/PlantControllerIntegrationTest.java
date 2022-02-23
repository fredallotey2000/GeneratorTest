package com.generatortest.generatortest;

import com.generatortest.generatortest.controller.PlantController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class PlantControllerIntegrationTest {

    @Autowired
    PlantController plantController;

    @Test
    public void testGetPlantSuccess() throws Exception {
//        ResponseEntity plant = plantController.getPlant(5L);
//        Assertions.assertEquals(plant.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Test
    public void testGetPlantFail() {
//        ResponseEntity plant = plantController.getPlant(-4L);
//        assertEquals(plant.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Test
    public void testGetPlantByLocationSuccess() {
//
////        mvc.perform(get("/posts/1/comments")).andExpect(jsonPath("$").isArray())
////                .andExpect(jsonPath("$.[0].postId", is(1))).andExpect(jsonPath("$.[0].message", is("test comment1")))
////                .andDo(print());
//        ResponseEntity plant = null;
//        try {
//            plant = plantController.getPlants("AK", null, null, null, 0, 3);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(PlantControllerIntegrationTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        // assertNotNull(plant.get);
//        assertNotNull(plant.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Test
    public void testGetPlantByLocationFail() {
//        ResponseEntity plant = null;
//        try {
//            plant = plantController.getPlants("AK", null, null, null, 0, -3);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(PlantControllerIntegrationTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        assertNotNull(plant.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Test
    public void testGetTopPlantsSuccess() {
//        ResponseEntity plant = null;
//        try {
//            plant = plantController.getPlants(null, 5, null, "asc", null, null);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(PlantControllerIntegrationTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        assertNotNull(plant);
//        assertNotNull(plant.getStatusCode() == HttpStatus.OK);
    }

    @Test
    public void testGetTopPlantsFail() {
//        ResponseEntity plant = null;
//        try {
//            plant = plantController.getPlants(null, -5, null, "asc", null, null);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(PlantControllerIntegrationTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        assertNotNull(plant.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Test
    public void testGetBottomPlantsSuccess() {
//        ResponseEntity plant = null;
//        try {
//            plant = plantController.getPlants(null, null, 5, "desc", null, null);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(PlantControllerIntegrationTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        assertNotNull(plant);
//        assertNotNull(plant.getStatusCode() == HttpStatus.OK);
    }

    @Test
    public void testGetBottomPlantsFail() {
//        ResponseEntity plant = null;
//        try {
//            plant = plantController.getPlants(null, -5, null, "asc", null, null);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(PlantControllerIntegrationTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        assertNotNull(plant.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
