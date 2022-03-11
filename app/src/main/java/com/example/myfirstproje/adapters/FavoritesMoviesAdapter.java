package com.example.myfirstproje.adapters;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfirstproje.R;
import com.example.myfirstproje.binding.ImageBindingAdapter;
import com.example.myfirstproje.models.FavoriteMovie;
import com.example.myfirstproje.models.MovieGenre;
import com.example.myfirstproje.models.MovieModel;

import java.util.List;

public class FavoritesMoviesAdapter extends RecyclerView.Adapter<FavoritesMoviesAdapter.ViewHolder> {
    private final Context context;
    private final List<FavoriteMovie> movielist;
    private final OnItemClickListener listener;


    public FavoritesMoviesAdapter(Context context, List<FavoriteMovie> movieList, OnItemClickListener listener) {
        this.context = context;
        this.movielist = movieList;
        this.listener=listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_favorites_movies_item, parent, false);
        return new ViewHolder(view);

    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FavoriteMovie movieItem = movielist.get(position);
        holder.setData(movieItem);

    }
    @Override
    public int getItemCount() {
        if (movielist == null)
            return 0;
        return movielist.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        CardView parentView;
        ImageView moviePoster;
        TextView movieName;
        TextView movieReleaseDate;
        TextView movieGenres;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parentView = itemView.findViewById(R.id.parent_view);
            moviePoster = itemView.findViewById(R.id.movie_poster);
            movieName = itemView.findViewById(R.id.movie_name);
            movieGenres = itemView.findViewById(R.id.movie_genre);
            movieReleaseDate = itemView.findViewById(R.id.movie_release_date);
        }

        public void setData(FavoriteMovie movieItem) {
            movieName.setText(movieItem.getMovieName());
            movieReleaseDate.setText(movieItem.getRelease_date());
            ImageBindingAdapter.loadImage(moviePoster, movieItem.getPoster_path());
            //parentview?
            parentView.setOnClickListener(view -> {
                if (listener != null)
                    listener.onItemClick(getAdapterPosition());

            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}


