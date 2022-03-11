package com.example.myfirstproje.fragments;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myfirstproje.Repository.FavoritesRepository;
import com.example.myfirstproje.models.FavoriteMovie;

import java.util.List;

public class FavoritesMoviesViewModel extends AndroidViewModel {
    private final FavoritesRepository repository;

    public FavoritesMoviesViewModel(Application application) {
        super(application);
        repository = new FavoritesRepository(application.getApplicationContext());
    }

    public void insert(FavoriteMovie movieModel) {
        repository.insert(movieModel);
    }

    public void delete(FavoriteMovie movieModel) {
        repository.delete(movieModel);
    }


    public LiveData<List<FavoriteMovie>> getAllFavorites() {
        return repository.getGetAllFavorites();
    }

}
