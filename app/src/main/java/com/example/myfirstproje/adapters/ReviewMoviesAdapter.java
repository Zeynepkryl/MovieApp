package com.example.myfirstproje.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfirstproje.R;
import com.example.myfirstproje.databinding.LayoutReviewMoviesItemBinding;
import com.example.myfirstproje.models.MovieModel;
import com.example.myfirstproje.models.MovieReviewResponce;
import com.example.myfirstproje.models.MovieReviewResult;

import java.util.List;

public class ReviewMoviesAdapter extends RecyclerView.Adapter<ReviewMoviesAdapter.ReviewHolder> {
    private final Context context;
    private final List<MovieReviewResult> reviewResultList;



    public ReviewMoviesAdapter(Context context, List<MovieReviewResult> reviewResultList) {
        this.context = context;
        this.reviewResultList = reviewResultList;



    }

    @NonNull
    @Override
    public ReviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_review_movies_item, parent, false);
        return new ReviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewHolder holder, int position) {
        MovieReviewResult movieItem = reviewResultList.get(position);
        holder.setData(movieItem);


    }

    @Override
    public int getItemCount() {
        if (reviewResultList == null)
            return 0;
        return reviewResultList.size();


    }


    public class ReviewHolder extends RecyclerView.ViewHolder {
        private LayoutReviewMoviesItemBinding binding;

        TextView author;
        TextView content;
        TextView url;

        /*  public ReviewHolder(LayoutReviewMoviesBinding binding) {
              super(binding.getRoot());

              this.binding=binding;
          }

         */
        public ReviewHolder(@NonNull View itemView) {
            super(itemView);
            author = itemView.findViewById(R.id.author);
            content = itemView.findViewById(R.id.content);
            url = itemView.findViewById(R.id.url);


        }

        public void setData(MovieReviewResult movieItem) {
            author.setText(movieItem.getAuthor());
            content.setText(movieItem.getContent());
            url.setText(movieItem.getUrl());

        }




    }
}
