package com.example.myfirstproje.models;

import com.google.gson.annotations.SerializedName;

public class MovieGenre {
    @SerializedName("id")
    int id;
    @SerializedName("name")
    String name;


    public MovieGenre() {
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
