package com.aldren.Swapi_test.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
public class People implements Serializable {

    private String name;

    @JsonProperty("birth_year")
    private String birthYear;

    @JsonProperty("films")
    private List<String> filmsUrls;

    private String gender;

    @JsonProperty("hair_color")
    private String hairColor;

    private String height;

    @JsonProperty("homeworld")
    private String homeWorldUrl;

    private String mass;

    @JsonProperty("skin_color")
    private String skinColor;

    private String created;
    private String edited;
    private String url;

    @JsonProperty("species")
    private List<String> speciesUrls;

    @JsonProperty("starships")
    private List<String> starshipsUrls;

    @JsonProperty("vehicles")
    private List<String> vehiclesUrls;
}

