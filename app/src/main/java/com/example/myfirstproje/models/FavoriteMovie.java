package com.example.myfirstproje.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

//Entity: Model sınıfının üstüne eklenir.Bu sınıfın tablo old. room a bildirmek için kullanılır.
@Entity(tableName = "Favorites")
public class FavoriteMovie {
    /*PrimaryKey: Tablodaki primary key olacak değeri belirlemek için kullanılır Primary key veriler arasındaki karışıklığı
    Gidermek için kullanılır.Bu sebeple Annotation kullanmamız gerekir. autoGenerate argümanı bulunmaktadır.İd lere otomatik
    artan bir yapı kazandırmak istiyorsak true veriyoruz*/
    //ColumnInfo: Sınıfın değişkenlerinin isimlerini özelleştirmek için kullanılır.
    @PrimaryKey
    @ColumnInfo(name = "movie_id")
    public int movieId;
    @ColumnInfo(name = "movie_name")
    public String movieName;
    @ColumnInfo(name = "release_date")
    public String release_date;
    @ColumnInfo(name = "poster_path")
    public String poster_path;

    @ColumnInfo(name = "isFavorites")
    public boolean isFavorites;

    public boolean isFavorites() {
        return isFavorites;
    }

    public void setFavorites(boolean favorites) {
        isFavorites = favorites;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }
}
