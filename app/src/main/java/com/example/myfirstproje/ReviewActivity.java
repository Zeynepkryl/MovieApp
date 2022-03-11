package com.example.myfirstproje;

import static com.example.myfirstproje.R.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.myfirstproje.adapters.ReviewMoviesAdapter;
import com.example.myfirstproje.databinding.ActivityReviewBinding;
import com.example.myfirstproje.fragments.ReviewMoviesViewModel;
import com.example.myfirstproje.models.MovieReviewResponce;
import com.example.myfirstproje.models.MovieReviewResult;

import java.util.ArrayList;
import java.util.List;

public class ReviewActivity extends AppCompatActivity {
    ActivityReviewBinding binding;
    TextView author, content, url;
    private ReviewMoviesAdapter adapter;
    ReviewMoviesViewModel viewModel;
    private List<MovieReviewResult> reviewList;


    public ReviewActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        author = findViewById(id.author);
        content = findViewById(id.content);
        url = findViewById(id.url);


        Integer id = getIntent().getIntExtra("id", 0);
        reviewList = new ArrayList<>();
        viewModel = new ViewModelProvider(this).get(ReviewMoviesViewModel.class);
        adapter = new ReviewMoviesAdapter(getApplicationContext(), reviewList);
        binding.reviewList.setAdapter(adapter);
        binding.reviewList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        viewModel.getMovieReviewResult(id).observe(this, new Observer<List<MovieReviewResult>>() {
            @Override
            public void onChanged(List<MovieReviewResult> movieReviewResults) {

                reviewList.clear();
                reviewList.addAll(movieReviewResults);

                adapter.notifyDataSetChanged();

/*
               binding.contenttextView.setText(movieReviewResults.get(0).getContent());
               binding.authortextView.setText(movieReviewResults.get(0).getAuthor());
               binding.urltextView.setText(movieReviewResults.get(0).getUrl());

 */
            }
        });


    }

}