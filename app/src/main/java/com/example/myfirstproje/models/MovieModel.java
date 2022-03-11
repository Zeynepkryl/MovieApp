package com.example.myfirstproje.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieModel {
    @SerializedName("id")
    int id;
    @SerializedName("release_date")
    String release_date;
    @SerializedName("title")
    String title;
    @SerializedName("poster_path")
    String poster_path;
    @SerializedName("genres")
    List<MovieGenre> genreList;

    Boolean isFavori = false;


     public MovieModel() {
     }

     public Boolean getFavori() {
         return isFavori;
     }

     public void setFavori(Boolean favori) {
         isFavori = favori;
     }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public List<MovieGenre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<MovieGenre> genreList) {
        this.genreList = genreList;
    }
}
