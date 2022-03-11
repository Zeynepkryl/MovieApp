package com.example.myfirstproje.models;

import com.google.gson.annotations.SerializedName;

public class MovieDetailGenre {
    @SerializedName("id")
    int id;
    @SerializedName("name")
    String name;

    public MovieDetailGenre() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
