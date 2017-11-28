package mk.ukim.finki.mpip.lab_rest.persistence;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import mk.ukim.finki.mpip.lab_rest.models.MovieShort;

@Dao
public interface MovieShortDao {

    @Query("select * from movieshort")
    List<MovieShort> getAll();

    @Query("select * from movieshort where imdb_id = :id")
    MovieShort getMovie(String id);

    @Insert
    void insertAll(List<MovieShort> movies);

}
