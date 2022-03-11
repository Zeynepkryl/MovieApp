package com.example.myfirstproje.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.myfirstproje.OverviewActivity;
import com.example.myfirstproje.R;
import com.example.myfirstproje.ReviewActivity;
import com.example.myfirstproje.adapters.LatestMoviesAdapter;
import com.example.myfirstproje.databinding.FragmentLastestMoviesBinding;
import com.example.myfirstproje.models.FavoriteMovie;
import com.example.myfirstproje.models.MovieModel;

import java.util.ArrayList;
import java.util.List;

public class LastestMoviesFragment extends Fragment {
    FragmentLastestMoviesBinding binding;
    private LatestMoviesAdapter adapter;
    private List<MovieModel> lastestList;
    LastestMoviesViewModel viewModel;
    PopupMenu pm;
    boolean isPopupShown = false;

    public LastestMoviesFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = FragmentLastestMoviesBinding.inflate(inflater, container, false);
        lastestList = new ArrayList<>();


        viewModel = new ViewModelProvider(this)
                .get(LastestMoviesViewModel.class);

        refreshList(false);
        adapter = new LatestMoviesAdapter(requireContext(), lastestList, new LatestMoviesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                //DetailActivity geçsin

                if (pm != null && isPopupShown == true) {
                    pm.dismiss();
                }

                pm = new PopupMenu(requireContext(), view);
                pm.getMenuInflater().inflate(R.menu.popup_menu, pm.getMenu());
                pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.overview:
                                lastestList.get(position);
                                Intent intent = new Intent(getActivity(), OverviewActivity.class);
                                intent.putExtra("id", lastestList.get(position).getId());
                                startActivity(intent);
                                Toast.makeText(requireContext(), "Clicked Overview ", Toast.LENGTH_SHORT).show();
                                return true;

                            case R.id.review:
                                lastestList.get(position);
                                Intent i = new Intent(getActivity(), ReviewActivity.class);
                                i.putExtra("id", lastestList.get(position).getId());
                                startActivity(i);
                                Toast.makeText(requireContext(), "Clicked Review", Toast.LENGTH_SHORT).show();
                                return true;
                        }
                        return true;
                    }
                });
                pm.setOnDismissListener(new PopupMenu.OnDismissListener() {
                    @Override
                    public void onDismiss(PopupMenu popupMenu) {

                        isPopupShown = false;
                    }
                });
                pm.show();
                isPopupShown = true;


            }


            @Override
            public void onItemSavedClick(int position) {
                viewModel.insertFavorites(lastestList.get(position));
                Toast.makeText(requireContext(), "Successfully Saved", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onItemDeletedClick(int position) {
                viewModel.deleteFavorites(lastestList.get(position));
                Toast.makeText(requireContext(), "Successfully Deleted", Toast.LENGTH_SHORT).show();

            }
        });
        binding.lastestList.setAdapter(adapter);
        binding.lastestList.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.refreshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshList(true);
            }
        });
        return binding.getRoot();

    }

    public void refreshList(boolean fromRefreshLayout) {
        viewModel.getLatestMovies().observe(getViewLifecycleOwner(), new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {
                lastestList.clear();
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
                lastestList.addAll(movieModels);
                adapter.notifyDataSetChanged();

                if (fromRefreshLayout)
                    binding.refreshlayout.setRefreshing(false);

            }
        });
    }
}