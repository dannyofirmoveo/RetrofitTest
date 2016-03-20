package com.dannyofir.www.retrofittest;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dannyofir on 01/03/2016.
 */
public class MovieList {
    // I forgot the SerializedName
    @SerializedName("Search")
    List<Movie> movieList;
}
