package com.dannyofir.www.retrofittest;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by dannyofir on 01/03/2016.
 */
public interface GetMovieApi {

    @GET("/")
    Call<MovieList> getMovieList(@Query("s")String movie);

}
