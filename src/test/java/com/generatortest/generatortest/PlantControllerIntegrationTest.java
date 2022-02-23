package com.generatortest.generatortest;

import com.generatortest.generatortest.data.Plant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class PlantControllerIntegrationTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void testGetPlantSuccess() throws Exception {
        ResponseEntity<Plant> response = testRestTemplate.withBasicAuth("gentest", "genTest123$").
                getForEntity("/api/plants/5", Plant.class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetPlantFail() {
        ResponseEntity<String> response = testRestTemplate.withBasicAuth("gentest", "genTest123$").
                getForEntity("/api/plants/-5", String.class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    public void testGetPlantByLocationSuccess() {
        ResponseEntity<Plant[]> response = testRestTemplate.withBasicAuth("gentest", "genTest123$").
                getForEntity("/api/plants?location=AK&page=0&size=3", Plant[].class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetPlantByLocationFail() {
        ResponseEntity<String> response = testRestTemplate.withBasicAuth("gentest", "genTest123$").
                getForEntity("/api/plants?location=AK&page=-2&size=3", String.class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Test
    public void testGetTopPlantsSuccessAsc() {
        ResponseEntity<Plant[]> response = testRestTemplate.withBasicAuth("gentest", "genTest123$").
                getForEntity("/api/plants?top=5&sort=asc", Plant[].class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(response.getBody().length, 5);
    }
    
       @Test
    public void testGetTopPlantsSuccessDesc() {
        ResponseEntity<Plant[]> response = testRestTemplate.withBasicAuth("gentest", "genTest123$").
                getForEntity("/api/plants?top=5&sort=desc", Plant[].class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(response.getBody().length, 5);
    }

    @Test
    public void testGetBottomPlantsSuccesAsc() {
       ResponseEntity<Plant[]> response = testRestTemplate.withBasicAuth("gentest", "genTest123$").
                getForEntity("/api/plants?bottom=5&sort=asc", Plant[].class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(response.getBody().length, 5);
    }
    
     @Test
    public void testGetBottomPlantsSuccesDesc() {
       ResponseEntity<Plant[]> response = testRestTemplate.withBasicAuth("gentest", "genTest123$").
                getForEntity("/api/plants?bottom=5&sort=desc", Plant[].class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(response.getBody().length, 5);
    }

}
