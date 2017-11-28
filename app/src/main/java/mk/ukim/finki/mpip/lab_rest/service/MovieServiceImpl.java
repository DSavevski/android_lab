package mk.ukim.finki.mpip.lab_rest.service;


import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import java.util.List;

import mk.ukim.finki.mpip.lab_rest.models.MovieShort;
import mk.ukim.finki.mpip.lab_rest.persistence.AppDatabase;

public class MovieServiceImpl extends IntentService{

    public static List<MovieShort> movies;
    public static AppDatabase db;


    public MovieServiceImpl(){
        super("WATAFAK");
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        db.movieShortDao().insertAll(movies);
    }

    public List<MovieShort> getMovies(){

        return db.movieShortDao().getAll();
    }

    public MovieShort getMovie(String name){

        return db.movieShortDao().getMovie(name);
    }

}
