package mk.ukim.finki.mpip.lab_rest.rest;

import android.support.annotation.NonNull;

import mk.ukim.finki.mpip.lab_rest.BuildConfig;
import mk.ukim.finki.mpip.lab_rest.models.MovieFull;
import mk.ukim.finki.mpip.lab_rest.models.Search;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieApiRepositoryImpl implements MovieApiRepository {

    private ApiService apiService;

    public MovieApiRepositoryImpl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    @Override
    public Call<Search> searchMovies(@NonNull String name) {
        return apiService.searchMovies(BuildConfig.OMDBApiKey, name, "movie");
    }

    @Override
    public Call<MovieFull> getMovieById(@NonNull String id) {
        return apiService.getMovieById(BuildConfig.OMDBApiKey, id, "full");
    }
}
