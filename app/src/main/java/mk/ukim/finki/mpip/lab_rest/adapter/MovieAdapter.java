package mk.ukim.finki.mpip.lab_rest.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import mk.ukim.finki.mpip.lab_rest.R;
import mk.ukim.finki.mpip.lab_rest.models.MovieShort;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<MovieShort> movies;
    private OnMovieClickListener listener;

    public MovieAdapter(List<MovieShort> movies, OnMovieClickListener listener) {
        this.movies = movies;
        this.listener = listener;
    }

    public ArrayList<MovieShort> getMovies() {
        return new ArrayList<>(movies);
    }

    public void removeMovie(int index) {
        if (index < movies.size()) {
            movies.remove(index);
            notifyItemRemoved(index);
        }
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        final MovieShort movie = movies.get(position);
        Picasso.with(holder.itemView.getContext())
                .load(movie.getPoster())
                .placeholder(R.drawable.ic_action_download)
                .resize(128, 128)
                .centerCrop()
                .into(holder.getImgMoviePoster());
        holder.getTxtMovieName().setText(movie.getTitle());
        holder.getTxtMovieYear().setText(movie.getYear());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onMovieClick(movie.getImdbID());
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                listener.onLongMovieClick(movie.getImdbID());
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void clear() {
        movies.clear();
        notifyDataSetChanged();
    }

    public void init(List<MovieShort> movies) {
        this.movies.addAll(movies);
        notifyDataSetChanged();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgMoviePoster;
        private TextView txtMovieName;
        private TextView txtMovieYear;

        MovieViewHolder(View itemView) {
            super(itemView);
            imgMoviePoster = itemView.findViewById(R.id.imgMoviePoster);
            txtMovieName = itemView.findViewById(R.id.txtMovieName);
            txtMovieYear = itemView.findViewById(R.id.txtMovieYear);
        }

        ImageView getImgMoviePoster() {
            return imgMoviePoster;
        }

        TextView getTxtMovieName() {
            return txtMovieName;
        }

        TextView getTxtMovieYear() {
            return txtMovieYear;
        }
    }

    public interface OnMovieClickListener {
        void onMovieClick(String imdbId);
        void onLongMovieClick(String imdbId);
    }
}
