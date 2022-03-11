package com.example.myfirstproje.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myfirstproje.binding.ImageBindingAdapter;
import com.example.myfirstproje.databinding.FragmentOverviewBinding;
import com.example.myfirstproje.models.MovieOverviewResult;

public class OverviewMoviesFragment extends Fragment {
    FragmentOverviewBinding binding;
    OverviewMoviesViewModel viewModel;
    int movieId;

    public OverviewMoviesFragment(int movieId) {
        this.movieId = movieId;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentOverviewBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(OverviewMoviesViewModel.class);
        viewModel.getMovieDetailResult(movieId).observe(getViewLifecycleOwner(), new Observer<MovieOverviewResult>() {
            @Override
            public void onChanged(MovieOverviewResult movieOverviewResult) {
                binding.overview.setText("" + movieOverviewResult.getOverview());
                binding.releaseDate.setText("" + movieOverviewResult.getReleaseDate());
                binding.title.setText("" + movieOverviewResult.getTitle());
                binding.voteCount.setText("" + String.valueOf(movieOverviewResult.getVoteCount()));
                binding.voteAverage.setText(""+movieOverviewResult.getVoteAverage());
                binding.movieName.setText(""+movieOverviewResult.getDetailGenreList().get(1).getName());
                binding.budget.setText(""+movieOverviewResult.getBudget());
                binding.originalLanguage.setText(""+movieOverviewResult.getOriginalLanguage());
                binding.status.setText(""+movieOverviewResult.getStatus());
                binding.revenue.setText(""+movieOverviewResult.getRevenue());
                binding.tagLine.setText(""+movieOverviewResult.getTagLine());
                ImageBindingAdapter.loadImage(binding.posterPath,movieOverviewResult.getPosterPath());


            }
        });
        return binding.getRoot();
    }
}
