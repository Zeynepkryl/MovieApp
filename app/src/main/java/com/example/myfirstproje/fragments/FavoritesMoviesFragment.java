package com.example.myfirstproje.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myfirstproje.adapters.FavoritesMoviesAdapter;
import com.example.myfirstproje.databinding.FragmentFavoritesMoviesBinding;
import com.example.myfirstproje.models.FavoriteMovie;

import java.util.ArrayList;
import java.util.List;

public class FavoritesMoviesFragment extends Fragment {

    FragmentFavoritesMoviesBinding binding;
    private FavoritesMoviesAdapter adapter;
    private List<FavoriteMovie> favoritesList;
    FavoritesMoviesViewModel viewModel;

    public FavoritesMoviesFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        binding = FragmentFavoritesMoviesBinding.inflate(inflater, container, false);
        favoritesList = new ArrayList<>();

        /*Bu kısım servisten gelen data ile dolacak*/
        ViewModelProvider viewModelProvider = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> aClass) {
                return (T) new FavoritesMoviesViewModel(getActivity().getApplication());
            }
        });

        viewModel = viewModelProvider.get(FavoritesMoviesViewModel.class);
        getFavoriteMovies();

        adapter = new FavoritesMoviesAdapter(requireContext(), favoritesList, new FavoritesMoviesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

            }
        });

        binding.favoritesList.setAdapter(adapter);
        binding.favoritesList.setLayoutManager(new LinearLayoutManager(requireContext()));
        return binding.getRoot();

    }

    private void getFavoriteMovies() {
        viewModel.getAllFavorites().observe(getViewLifecycleOwner(), new Observer<List<FavoriteMovie>>() {
            @Override
            public void onChanged(List<FavoriteMovie> movieModels) {
                favoritesList.clear();
                favoritesList.addAll(movieModels);
                adapter.notifyDataSetChanged();
            }
        });
    }
}

//test1