package com.example.myfirstproje.fragments;

import android.net.CaptivePortal;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.load.data.StreamAssetPathFetcher;
import com.example.myfirstproje.adapters.TopRatedMoviesAdapter;
import com.example.myfirstproje.databinding.FragmentTopratedBinding;
import com.example.myfirstproje.models.FavoriteMovie;
import com.example.myfirstproje.models.MovieModel;

import java.util.ArrayList;
import java.util.List;

public class TopRatedMoviesFragment extends Fragment {
    FragmentTopratedBinding binding;
    private TopRatedMoviesAdapter adapter;
    private List<MovieModel> topratedList;
    TopRatedViewModel viewModel;

    public TopRatedMoviesFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTopratedBinding.inflate(inflater, container, false);
        topratedList = new ArrayList<>();

        viewModel = new ViewModelProvider(this)
                .get(TopRatedViewModel.class);

        refreshList(false);

        adapter = new TopRatedMoviesAdapter(requireContext(), topratedList, new TopRatedMoviesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                viewModel.insertFavorites(topratedList.get(position));
            }

            @Override
            public void onItemSavedClick(int position) {
                viewModel.insertFavorites(topratedList.get(position));
                Toast.makeText(requireContext(), "Successful Saved", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemDeletedClick(int position) {
                viewModel.deleteFavorites(topratedList.get(position));
                Toast.makeText(requireContext(), "Successful Deleted", Toast.LENGTH_SHORT).show();
            }

        });

        binding.topratedList.setAdapter(adapter);
        binding.topratedList.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.refreshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {


            @Override
            public void onRefresh() {
                refreshList(true);

            }
        });
        return binding.getRoot();
    }

    public void refreshList(boolean fromRefreshLayout) {
        viewModel.getTopRatedMovies().observe(getViewLifecycleOwner(), new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {
                topratedList.clear();
                for (MovieModel modelItem : movieModels) {
                    viewModel.getFavoriteMovie(modelItem.getId()).observe(getViewLifecycleOwner(), new Observer<FavoriteMovie>() {

                        @Override
                        public void onChanged(FavoriteMovie movie) {
                            if (movie != null) {
                                modelItem.setFavori(true);
                            }
                            adapter.notifyDataSetChanged();
                        }


                    });
                }
                topratedList.addAll(movieModels);
                adapter.notifyDataSetChanged();

                if (fromRefreshLayout)
                    binding.refreshlayout.setRefreshing(false);

            }

        });

    }
}




