package com.example.myfirstproje.fragments;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.myfirstproje.Constants;
import com.example.myfirstproje.data.remote.ApiClient;
import com.example.myfirstproje.data.remote.ApiService;
import com.example.myfirstproje.models.MovieModel;
import com.example.myfirstproje.models.MovieReviewResponce;
import com.example.myfirstproje.models.MovieReviewResult;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReviewMoviesViewModel extends AndroidViewModel {


    public ReviewMoviesViewModel(@NonNull Application application) {

        super(application);
    }

    public MutableLiveData<List<MovieReviewResult>> getMovieReviewResult(int id) {
        MutableLiveData<List<MovieReviewResult>> reviewMovies = new MutableLiveData<>();
        List<MovieReviewResult> reviewResultList = new ArrayList<>();
        ApiService apiService = ApiClient.createApiClient().create(ApiService.class);
        apiService.getMovieReviewResult(id, Constants.API_KEY).enqueue(new Callback<MovieReviewResponce>() {
            @Override
            public void onResponse(Call<MovieReviewResponce> call, Response<MovieReviewResponce> response) {
                if (response.isSuccessful())
                    reviewMovies.setValue(response.body().getResults());



            }


            @Override
            public void onFailure(Call<MovieReviewResponce> call, Throwable t) {

                String s = "";


            }
        });
        return reviewMovies;

    }


}
