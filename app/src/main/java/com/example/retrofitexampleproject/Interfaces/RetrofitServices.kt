package com.example.retrofitexampleproject.Interfaces

import com.example.retrofitexampleproject.Model.Movie
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServices {
    @GET("marvel")
    fun getMovieList(): Call<MutableList<Movie>>
}