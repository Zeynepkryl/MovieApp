package com.example.myfirstproje.roomdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.myfirstproje.models.FavoriteMovie;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {FavoriteMovie.class}, version = 1)
public abstract class FavoritesMoviesRoomDataBase extends RoomDatabase {
    public static volatile FavoritesMoviesRoomDataBase INSTANCE;

    public abstract Dao favoritesDao();

    public static final ExecutorService databaseWriterService = Executors.newFixedThreadPool(1);

    public static FavoritesMoviesRoomDataBase getInstance(Context context) {
        if (INSTANCE == null) {
      //Metoda ulaşmak isteyen threadler metoda sıra ile girer ve bir thread metodu bitirmeden diğeri giremez
            synchronized (FavoritesMoviesRoomDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), FavoritesMoviesRoomDataBase.class, "Favorites.db").build();
                }


            }
        }

        return INSTANCE;
    }
}


