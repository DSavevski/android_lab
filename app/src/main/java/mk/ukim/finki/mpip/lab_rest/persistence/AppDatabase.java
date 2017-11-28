package mk.ukim.finki.mpip.lab_rest.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import mk.ukim.finki.mpip.lab_rest.models.MovieShort;


@Database(entities = {MovieShort.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract MovieShortDao movieShortDao();

}
