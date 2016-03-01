package com.dannyofir.www.retrofittest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Callback<MovieList> {

    private ListView listViewMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewMain = (ListView) findViewById(R.id.listViewMain);



        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, new ArrayList());

        listViewMain.setAdapter(arrayAdapter);



    }

    public void button_onClick(View view) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.omdbapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GetMovieApi api = retrofit.create(GetMovieApi.class);

        Call<MovieList> call = api.getMovieList("Saving");

        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<MovieList> call, Response<MovieList> response) {
        ArrayAdapter<Movie> adapter = (ArrayAdapter<Movie>) listViewMain.getAdapter();
        adapter.clear();
        adapter.addAll(response.body().movieList);
    }

    @Override
    public void onFailure(Call<MovieList> call, Throwable t) {
        Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
    }
}
