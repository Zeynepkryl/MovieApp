package com.example.myfirstproje.fragments;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.myfirstproje.Constants;
import com.example.myfirstproje.data.remote.ApiClient;
import com.example.myfirstproje.data.remote.ApiService;
import com.example.myfirstproje.models.MovieOverviewResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OverviewMoviesViewModel extends AndroidViewModel {


    public OverviewMoviesViewModel(@NonNull Application application) {

        super(application);
    }

    public MutableLiveData<MovieOverviewResult> getMovieDetailResult(int id) {
        MutableLiveData<MovieOverviewResult> detailMovies = new MutableLiveData<>();
        ApiService apiService = ApiClient.createApiClient().create(ApiService.class);
        apiService.getMovieDetailResult(id, Constants.API_KEY ).enqueue(new Callback<MovieOverviewResult>() {
            @Override
            public void onResponse(@NonNull Call<MovieOverviewResult> call, @NonNull Response<MovieOverviewResult> response) {
                if (response.isSuccessful())
                    detailMovies.setValue(response.body());

            }

            @Override
            public void onFailure(@NonNull Call<MovieOverviewResult> call, @NonNull Throwable t) {
                 String s="";




            }

        });
        return detailMovies;
    }


}
