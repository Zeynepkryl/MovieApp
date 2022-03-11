package com.example.myfirstproje.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myfirstproje.R;
import com.example.myfirstproje.adapters.ReviewMoviesAdapter;
import com.example.myfirstproje.databinding.FragmentReviewBinding;
import com.example.myfirstproje.models.MovieReviewResponce;
import com.example.myfirstproje.models.MovieReviewResult;

import java.util.ArrayList;
import java.util.List;

public class ReviewMoviesFragment extends Fragment {
    FragmentReviewBinding binding;
    private ReviewMoviesAdapter adapter;
    private List<MovieReviewResult> reviewList;
    ReviewMoviesViewModel viewModel;
    int movieId;


    public ReviewMoviesFragment(int movieId) {

        this.movieId = movieId;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentReviewBinding.inflate(inflater, container, false);
        reviewList = new ArrayList<>();
        viewModel = new ViewModelProvider(this)
                .get(ReviewMoviesViewModel.class);
        adapter = new ReviewMoviesAdapter(requireContext(), reviewList);
        binding.reviewList.setAdapter(adapter);
        binding.reviewList.setLayoutManager(new LinearLayoutManager(requireContext()));


        viewModel.getMovieReviewResult(movieId).observe(getViewLifecycleOwner(), new Observer<List<MovieReviewResult>>() {
            @Override
            public void onChanged(List<MovieReviewResult> movieReviewResults) {

                reviewList.clear();
                reviewList.addAll(movieReviewResults);

                adapter.notifyDataSetChanged();
            }
        });
        return binding.getRoot();

    }


}

