package com.example.myfirstproje.fragments;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myfirstproje.Constants;
import com.example.myfirstproje.Repository.FavoritesRepository;
import com.example.myfirstproje.data.remote.ApiClient;
import com.example.myfirstproje.data.remote.ApiService;
import com.example.myfirstproje.models.FavoriteMovie;
import com.example.myfirstproje.models.MovieModel;
import com.example.myfirstproje.models.MovieResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LastestMoviesViewModel extends AndroidViewModel {
    private final FavoritesRepository repository;

    public LastestMoviesViewModel(@NonNull Application application) {
        super(application);
        repository = new FavoritesRepository(application.getApplicationContext());
    }

    public MutableLiveData<List<MovieModel>> getLatestMovies() {
        MutableLiveData<List<MovieModel>> latestMovies = new MutableLiveData<>();
        ApiService apiService = ApiClient.createApiClient().create(ApiService.class);
        apiService.getLastestMovies(Constants.API_KEY).enqueue(new Callback<MovieResult>() {
            @Override
            public void onResponse(Call<MovieResult> call, Response<MovieResult> response) {
                if (response.isSuccessful())
                    latestMovies.setValue(response.body().getResults());

            }

            @Override
            public void onFailure(Call<MovieResult> call, Throwable t) {

            }
        });
        return latestMovies;
    }

    public void insertFavorites(MovieModel movieModel) {
        FavoriteMovie favoriteMovie = new FavoriteMovie();
        favoriteMovie.setMovieId(movieModel.getId());
        favoriteMovie.setMovieName(movieModel.getTitle());
        favoriteMovie.setPoster_path(movieModel.getPoster_path());
        favoriteMovie.setRelease_date(movieModel.getRelease_date());
        repository.insert(favoriteMovie);
    }

    public void deleteFavorites(MovieModel movieModel) {
        FavoriteMovie favoriteMovie = new FavoriteMovie();
        favoriteMovie.setMovieId(movieModel.getId());
        favoriteMovie.setMovieName(movieModel.getTitle());
        favoriteMovie.setPoster_path(movieModel.getPoster_path());
        favoriteMovie.setRelease_date(movieModel.getRelease_date());
        repository.delete(favoriteMovie);


    }


    public MutableLiveData<List<MovieModel>> getisFavoriteControl() {
        MutableLiveData<List<MovieModel>> isFavoriteControl = new MutableLiveData<>();
        ApiService apiService = ApiClient.createApiClient().create(ApiService.class);
        apiService.getLastestMovies(Constants.API_KEY).enqueue(new Callback<MovieResult>() {
            @Override
            public void onResponse(Call<MovieResult> call, Response<MovieResult> response) {
                if (response.isSuccessful())
                    getLatestMovies().setValue(response.body().getResults());
            }

            @Override
            public void onFailure(Call<MovieResult> call, Throwable t) {

            }
        });
        return isFavoriteControl;
    }

    public LiveData<FavoriteMovie> getFavoriteMovie(int id) {
        return repository.getFavoriteMovie(id);
    }
}
