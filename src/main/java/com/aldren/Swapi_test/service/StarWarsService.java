package com.aldren.Swapi_test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aldren.Swapi_test.model.CharacterEntity;
import com.aldren.Swapi_test.model.Film;
import com.aldren.Swapi_test.model.People;
import com.aldren.Swapi_test.model.SWResult;
import com.aldren.Swapi_test.model.SWModelList;
import com.aldren.Swapi_test.model.Vehicle;
import com.aldren.Swapi_test.repository.CharacterRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class StarWarsService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final CharacterRepository characterRepository;

    public StarWarsService(RestTemplate restTemplate, ObjectMapper objectMapper, CharacterRepository characterRepository) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.characterRepository = characterRepository;
    }

	public List<SWResult> getCharacterById(String id) {
    	try {
    		System.out.println("Searching for:"+id.replace(" ", "+") );
            String url = "https://swapi.dev/api/people?search=" + id.replace(" ", "+")+"&format=json" ;
            String jsonResponse = restTemplate.getForObject(url, String.class);
            SWModelList<People> sw = objectMapper.readValue(jsonResponse, new TypeReference<SWModelList<People>>() {});

            List<SWResult> results = new ArrayList<>();
        	System.out.println(sw.toString());
            for(People p: sw.getResults()) {
            	SWResult result = new SWResult();
            	result.setName(p.getName());
            	if(null==p.getVehiclesUrls() || p.getVehiclesUrls().isEmpty() ) {
            		result.setVehicleModel("NaN");
            	} else {
                    String vehicles = p.getVehiclesUrls().stream()
                            .map(this::getVehicleModel)
                            .collect(Collectors.joining(", "));
                    result.setVehicleModel(vehicles);
            	}
                if(null==p.getFilmsUrls() || p.getFilmsUrls().isEmpty()) {
                	result.setFilmName("NaN");
                } else {
                	String films = p.getFilmsUrls().stream()
                            .map(this::getFilmName)
                            .collect(Collectors.joining(", "));
                    result.setFilmName(films);
                }
                results.add(result);
            }
            return results;
    	} catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    	
    }
	
	public SWResult saveCharacter(String name, String filmName, String vehicleModel) {
        CharacterEntity character = new CharacterEntity();
        character.setName(name);
        character.setFilmName(filmName);
        character.setVehicleModel(vehicleModel);
        SWResult res = new SWResult();
        CharacterEntity ce= characterRepository.save(character);
        res.setFilmName(ce.getFilmName());
        res.setName(ce.getName());
        res.setVehicleModel(ce.getVehicleModel());
        return res;
    }

	private String getVehicleModel(String url) {
		Vehicle vehicle = restTemplate.getForObject(url, Vehicle.class);
		return vehicle != null ? vehicle.getModel() : "Vehicle Not Found";
	}

	private String getFilmName(String url) {
		Film vehicle = restTemplate.getForObject(url, Film.class);
		return vehicle != null ? vehicle.getTitle() : "Film Not Found";
	}
}
