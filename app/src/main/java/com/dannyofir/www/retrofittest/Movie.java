package com.dannyofir.www.retrofittest;

/**
 * Created by dannyofir on 01/03/2016.
 */
public class Movie {

    String Title;
    String imdbID;

    public Movie (){
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    @Override
    public String toString() {
        return Title + " imdbID: " + imdbID;
    }
}
