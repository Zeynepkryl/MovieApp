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
import com.example.myfirstproje.models.MovieGenre;
import com.example.myfirstproje.models.MovieModel;

import java.util.List;

public class TopRatedMoviesAdapter extends RecyclerView.Adapter<TopRatedMoviesAdapter.ViewHolder> {
    //public interface context
    private final Context context;
    private final List<MovieModel> movielist;
    private final OnItemClickListener listener;
    Boolean isFavorites = false;

    public TopRatedMoviesAdapter(Context context, List<MovieModel> movieList, OnItemClickListener listener) {
        this.context = context;
        this.movielist = movieList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_toprated_movies_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MovieModel movieItem = movielist.get(position);
        holder.setData(movieItem);
    }

    @Override
    public int getItemCount() {
        if (movielist == null)
            return 0;
        return movielist.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView yildizView;
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
            yildizView = itemView.findViewById(R.id.yildizIv);
            isFavorites = false;

        }

        public void setData(MovieModel movieItem) {
            movieName.setText(movieItem.getTitle());
            movieReleaseDate.setText(movieItem.getRelease_date());
            String movieGenre = "";
            if (movieItem.getGenreList() != null)
                for (MovieGenre genreItem : movieItem.getGenreList()) {
                    if (TextUtils.isEmpty(movieGenre))
                        movieGenre = genreItem.getName();
                    else
                        movieGenre = ", " + genreItem.getName();

                }
            movieGenres.setText(movieGenre);
            ImageBindingAdapter.loadImage(moviePoster, movieItem.getPoster_path());
            //parentview?
            parentView.setOnClickListener(view -> {
                if (listener != null)
                    listener.onItemClick(getAdapterPosition());

            });
            if (movieItem.getFavori())
                yildizView.setImageResource(R.drawable.ic_baseline_star_24);
            else {
                yildizView.setImageResource(R.drawable.ic_baseline_star_border_24);
            }

            yildizView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!movieItem.getFavori()) {
                        movieItem.setFavori(true);
                        listener.onItemSavedClick(getAdapterPosition());
                        yildizView.setImageResource(R.drawable.ic_baseline_star_24);
                    } else {
                        movieItem.setFavori(false);
                        listener.onItemDeletedClick(getAdapterPosition());
                        yildizView.setImageResource(R.drawable.ic_baseline_star_border_24);
                    }
                   movieItem.setFavori(!movieItem.getFavori());
                    notifyDataSetChanged();

                }
            });


        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);


        void onItemSavedClick(int position);

        void onItemDeletedClick(int position);


    }
}
