package mk.ukim.finki.mpip.lab_rest.rest;

import mk.ukim.finki.mpip.lab_rest.models.MovieFull;
import mk.ukim.finki.mpip.lab_rest.models.Search;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("/")
    Call<Search> searchMovies(@Query("apikey") String apiKey,
                              @Query("s") String name,
                              @Query("type") String type);

    @GET("/")
    Call<MovieFull> getMovieById(@Query("apikey") String apiKey,
                                 @Query("i") String id, @Query("plot") String plot);
}
