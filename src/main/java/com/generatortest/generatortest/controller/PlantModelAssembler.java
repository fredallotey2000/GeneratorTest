/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.generatortest.generatortest.controller;

import com.generatortest.generatortest.data.Plant;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

/**
 *
 * @author Bsystems4
 */
@Component
public class PlantModelAssembler implements RepresentationModelAssembler<Plant, EntityModel<Plant>> {

    @Override
    public EntityModel<Plant> toModel(Plant plant) {
        return EntityModel.of(plant,
                linkTo(methodOn(PlantController.class).getPlant(plant.getSequenceNumber())).withSelfRel());
    }

}
