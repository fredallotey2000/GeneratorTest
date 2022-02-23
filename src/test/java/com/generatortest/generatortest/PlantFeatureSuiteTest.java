package com.generatortest.generatortest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    PlantRepositoryIntegrationTest.class,
    PlantServiceIntegrationTest.class
})
public class PlantFeatureSuiteTest {

}
