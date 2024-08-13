package com.aldren.Swapi_test.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.aldren.Swapi_test.model.SWResult;
import com.aldren.Swapi_test.service.StarWarsService;

@Controller
public class StarWarsController {

	private final StarWarsService starWarsService;

    public StarWarsController(StarWarsService starWarsService) {
        this.starWarsService = starWarsService;
    }

    @QueryMapping
    public List<SWResult> searchCharacter(@Argument String name) {
        return starWarsService.getCharacterById(name);
    }

    @MutationMapping
    public SWResult saveCharacter(@Argument String name,@Argument String filmName,@Argument String vehicleModel) {
        return starWarsService.saveCharacter(name, filmName, vehicleModel);
    }
}
