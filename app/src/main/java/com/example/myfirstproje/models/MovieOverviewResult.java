package com.example.myfirstproje.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieOverviewResult {
    @SerializedName("id")
    int id;
    @SerializedName("release_date")
    String releaseDate;
    @SerializedName("overview")
    String overview;
    @SerializedName("title")
    String title;
    @SerializedName("vote_average")
    double voteAverage;
    @SerializedName("vote_count")
    int voteCount;
    @SerializedName("poster_path")
    String posterPath;
    @SerializedName("budget")
    int budget;
    @SerializedName("original_language")
    String originalLanguage;
    @SerializedName("status")
    String status;
    @SerializedName("revenue")
    int revenue;
    @SerializedName("tag_line")
    String tagLine;
    @SerializedName("genres")
    List<MovieDetailGenre> detailGenreList;



    public List<MovieDetailGenre> getDetailGenreList() {
        return detailGenreList;
    }

    public void setDetailGenreList(List<MovieDetailGenre> detailGenreList) {
        this.detailGenreList = detailGenreList;
    }

    public String getTagLine() {
        return tagLine;
    }

    public void setTagLine(String tagLine) {
        this.tagLine = tagLine;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }
}

