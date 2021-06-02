package com.example.retrofitexampleproject.Common

import com.example.retrofitexampleproject.Interfaces.RetrofitServices
import com.example.retrofitexampleproject.Retrofit.RetrofitClient

object Common {
    private val BASE_URL = "https://www.simplifiedcoding.net/demos/"
    //слева можем указать интерфейс, а справа все, что его реализует
    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}