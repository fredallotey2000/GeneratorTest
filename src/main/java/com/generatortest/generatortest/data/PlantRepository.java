/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.generatortest.generatortest.data;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bsystems4
 */
@EnableCaching
@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {

    List<Plant> findByPlantLocationCode(String plantLocationCode, @PageableDefault(size = 40) Pageable pageable);
    
    List<Plant> findByPlantLocationCode(String plantLocationCode);

    List<Plant> findByGeneratorId(Long generatorId);

    @Query("SELECT SUM(u.generatorAnnualNetGeneration) FROM Plant u WHERE u.plantLocationCode = ?1")
    BigDecimal getTotalGenoutputPerLocation(String plantLocationCode);

}
