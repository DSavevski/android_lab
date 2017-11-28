package mk.ukim.finki.mpip.lab_rest.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class MovieShort implements Parcelable {

    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Year")
    @Expose
    private String year;
    @SerializedName("imdbID")
    @Expose
    @PrimaryKey
    @ColumnInfo(name = "imdb_id")
    @NonNull
    private String imdbID;
    @SerializedName("Poster")
    @Expose
    private String poster;

    public MovieShort(){}

    protected MovieShort(Parcel in) {
        title = in.readString();
        year = in.readString();
        imdbID = in.readString();
        poster = in.readString();
    }

    public static final Creator<MovieShort> CREATOR = new Creator<MovieShort>() {
        @Override
        public MovieShort createFromParcel(Parcel in) {
            return new MovieShort(in);
        }

        @Override
        public MovieShort[] newArray(int size) {
            return new MovieShort[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Override
    public String toString() {
        return "MovieShort{" +
                "title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", imdbID='" + imdbID + '\'' +
                ", poster='" + poster + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(year);
        parcel.writeString(imdbID);
        parcel.writeString(poster);
    }
}
