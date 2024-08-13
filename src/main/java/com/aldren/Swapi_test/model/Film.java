package com.aldren.Swapi_test.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
public class Film implements Serializable {

    private String title;

    @SerializedName("episode_id")
    private int episodeId;

    @SerializedName("opening_crawl")
    private String openingCrawl;

    private String director;
    private String producer;
    private String release_date;
    private String url;
    private String created;
    private String edited;

    @SerializedName("species")
    private List<String> speciesUrls;

    @SerializedName("starships")
    private List<String> starshipsUrls;

    @SerializedName("vehicles")
    private List<String> vehiclesUrls;

    @SerializedName("planets")
    private List<String> planetsUrls;

    @SerializedName("characters")
    private List<String> charactersUrls;

}
