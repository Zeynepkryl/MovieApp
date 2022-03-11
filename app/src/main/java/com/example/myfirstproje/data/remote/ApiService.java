package com.example.myfirstproje.data.remote;

import com.example.myfirstproje.models.MovieOverviewResult;
import com.example.myfirstproje.models.MovieResult;
import com.example.myfirstproje.models.MovieReviewResponce;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    //Get: Url de açık post gizli
    @GET("movie/popular")
    Call<MovieResult> getLastestMovies(@Query("api_key") String apiKey);

    @GET("movie/top_rated")
    Call<MovieResult> getTopRated(@Query("api_key") String apiKey);

    @GET("movie/{movie_id}")
//Adresren gelen verileri al
    Call<MovieOverviewResult> getMovieDetailResult(@Path("movie_id") int movieId, @Query("api_key") String apiKey);/*<>Buradaki classa göre doldur.Bu metot
                                                                                     aracılığıyla bu verileri al*/

    @GET("movie/{movie_id}/reviews")
    Call<MovieReviewResponce> getMovieReviewResult(@Path("movie_id") int movieId,@Query("api_key") String apiKey );




}
