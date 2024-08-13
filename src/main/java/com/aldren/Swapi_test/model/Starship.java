package com.aldren.Swapi_test.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class Starship extends Vehicle implements Serializable {

    @SerializedName("starship_class")
    private String starshipClass;

    @SerializedName("hyperdrive_rating")
    private String hyperdriveRating;

    @SerializedName("MGLT")
    private String mglt;

}
