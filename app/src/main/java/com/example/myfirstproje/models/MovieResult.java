package com.example.myfirstproje.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResult {
    @SerializedName("page")
    int page;
    @SerializedName("results")
    List<MovieModel> results;
    @SerializedName("total_results")
    int total_results;
    @SerializedName("total_pages")
    int total_pages;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<MovieModel> getResults() {
        return results;
    }

    public void setResults(List<MovieModel> results) {
        this.results = results;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }
}
