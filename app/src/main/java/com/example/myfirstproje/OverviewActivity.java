package com.example.myfirstproje;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myfirstproje.binding.ImageBindingAdapter;
import com.example.myfirstproje.data.remote.ApiClient;
import com.example.myfirstproje.data.remote.ApiService;
import com.example.myfirstproje.databinding.ActivityOverviewBinding;
import com.example.myfirstproje.fragments.OverviewMoviesViewModel;
import com.example.myfirstproje.models.MovieOverviewResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OverviewActivity extends AppCompatActivity {
    ActivityOverviewBinding binding;
    ImageView poster_path;
    TextView title, vote_average, release_date, movie_name, overview, budget, original_Language, status, vote_count, revenue, tag_line;

    private OverviewMoviesViewModel overviewMoviesViewModel;


    public OverviewActivity() {

    }


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOverviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        poster_path = findViewById(R.id.poster_path);
        title = findViewById(R.id.title);
        vote_average = findViewById(R.id.vote_average);
        release_date = findViewById(R.id.release_date);
        movie_name = findViewById(R.id.movie_name);
        overview = findViewById(R.id.overview);
        budget = findViewById(R.id.budget);
        original_Language = findViewById(R.id.original_language);
        status = findViewById(R.id.status);
        vote_count = findViewById(R.id.vote_count);
        revenue = findViewById(R.id.revenue);
        tag_line = findViewById(R.id.tag_line);
        setSupportActionBar(binding.toolbar);


        Integer id = getIntent().getIntExtra("id", 0);


        overviewMoviesViewModel = new ViewModelProvider(this).get(OverviewMoviesViewModel.class);
        overviewMoviesViewModel.getMovieDetailResult(id).observe(this, new Observer<MovieOverviewResult>() {
            @Override
            public void onChanged(MovieOverviewResult movieOverviewResult) {

                ImageBindingAdapter.loadImage(poster_path, movieOverviewResult.getPosterPath());
                title.setText(movieOverviewResult.getTitle());
                vote_average.setText(String.valueOf(movieOverviewResult.getVoteAverage()));
                release_date.setText(movieOverviewResult.getReleaseDate());
                overview.setText(movieOverviewResult.getOverview());
                budget.setText(String.valueOf(movieOverviewResult.getBudget()));
                original_Language.setText(movieOverviewResult.getOriginalLanguage());
                status.setText(movieOverviewResult.getStatus());
                vote_count.setText(String.valueOf(movieOverviewResult.getVoteCount()));
                revenue.setText(String.valueOf(movieOverviewResult.getRevenue()));
                tag_line.setText(movieOverviewResult.getTagLine());
                movie_name.setText(movieOverviewResult.getDetailGenreList().get(1).getName());




            }
        });

    }


}







