package com.aldren.Swapi_test.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import lombok.Data;


@Data
public class Root implements Serializable {

    @SerializedName("films")
    private String filmsUrl;
    @SerializedName("people")
    private String peopleUrl;
    @SerializedName("planets")
    private String planetsUrl;
    @SerializedName("species")
    private String speciesUrl;
    @SerializedName("starships")
    private String starshipsUrl;
    @SerializedName("vehicles")
    private String vehiclesUrl;
}
