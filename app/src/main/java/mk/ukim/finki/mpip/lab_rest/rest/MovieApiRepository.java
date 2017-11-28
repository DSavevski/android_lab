package mk.ukim.finki.mpip.lab_rest.rest;

import android.support.annotation.NonNull;

import mk.ukim.finki.mpip.lab_rest.models.MovieFull;
import mk.ukim.finki.mpip.lab_rest.models.Search;
import retrofit2.Call;

public interface MovieApiRepository {

    Call<Search> searchMovies(@NonNull String name);

    Call<MovieFull> getMovieById(@NonNull String id);
}
