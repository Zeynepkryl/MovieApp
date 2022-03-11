package com.example.myfirstproje.roomdatabase;

import static androidx.room.OnConflictStrategy.FAIL;

import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.myfirstproje.Repository.FavoritesRepository;
import com.example.myfirstproje.models.FavoriteMovie;

import java.util.ArrayList;
import java.util.List;

//Verilere erişim sağlamak veri tabanında ekleme silme güncelleme yapmamız için
//Data Access Object
@androidx.room.Dao
public interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void InsertFavoriteMovie(FavoriteMovie movie);

    @Delete()
    void DeleteFavoriteMovie(FavoriteMovie movie);


    @Query("SELECT * FROM Favorites")
    LiveData<List<FavoriteMovie>> getAllFavorites();

    @Query("SELECT * FROM Favorites Where movie_id = :movieId")//Bu kısımdan true false çıkar
    LiveData<FavoriteMovie> getFavoriteMovie(int movieId);
/*
    @Query("SELECT * FROM Favorites Where isFavorites = :isFavorites")
    LiveData<FavoriteMovie> getFavoriteControl(boolean isFavorites);
*/

}
