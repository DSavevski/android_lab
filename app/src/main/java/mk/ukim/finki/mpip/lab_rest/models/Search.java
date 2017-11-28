package mk.ukim.finki.mpip.lab_rest.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Search {
    @SerializedName("Search")
    @Expose
    private List<MovieShort> search;

    public List<MovieShort> getSearch() {
        return search;
    }

    public void setSearch(List<MovieShort> search) {
        this.search = search;
    }
}
