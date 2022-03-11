package com.example.myfirstproje.Repository;

import android.content.Context;
import android.os.Parcel;

import androidx.lifecycle.LiveData;

import com.example.myfirstproje.models.FavoriteMovie;
import com.example.myfirstproje.roomdatabase.Dao;
import com.example.myfirstproje.roomdatabase.FavoritesMoviesRoomDataBase;

import java.util.List;

public class FavoritesRepository {
    private Dao dao;
    private LiveData<List<FavoriteMovie>> getAllFavorites;
    FavoritesMoviesRoomDataBase dataBase;


    public FavoritesRepository(Context context) {
        dataBase = FavoritesMoviesRoomDataBase.getInstance(context);
        dao = dataBase.favoritesDao();
    }

    public void insert(FavoriteMovie favoriteMovie) {
        FavoritesMoviesRoomDataBase.databaseWriterService.execute(new Runnable() {
            @Override
            public void run() {
                dao.InsertFavoriteMovie(favoriteMovie);
            }
        });
    }

    public void delete(FavoriteMovie favoriteMovie) {
        FavoritesMoviesRoomDataBase.databaseWriterService.execute(new Runnable() {
            @Override
            public void run() {
                dao.DeleteFavoriteMovie(favoriteMovie);
            }
        });
    }

    public LiveData<List<FavoriteMovie>> getGetAllFavorites() {

        return dao.getAllFavorites();
    }

    public LiveData<FavoriteMovie> getFavoriteMovie(int id) {
        return dao.getFavoriteMovie(id);
    }



}
