package com.example.retrofitexampleproject.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Fade
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitexampleproject.Adapter.MyMovieAdapter
import com.example.retrofitexampleproject.Common.Common
import com.example.retrofitexampleproject.Interfaces.RetrofitServices
import com.example.retrofitexampleproject.Model.Movie
import com.example.retrofitexampleproject.R

import retrofit2.Response
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {
    lateinit var mService: RetrofitServices
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: MyMovieAdapter
    lateinit var dialog: AlertDialog
    lateinit var recyclerMovieList: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fade = Fade()
        val decor:View = window.decorView
        fade.excludeTarget(decor.findViewById(R.id.action_bar_container) as View,true)
        fade.excludeTarget(android.R.id.statusBarBackground,true)
        fade.excludeTarget(android.R.id.navigationBarBackground,true)
        window.enterTransition = fade
        window.exitTransition = fade

        mService = Common.retrofitService
        recyclerMovieList = findViewById(R.id.recyclerMovieList)
        recyclerMovieList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerMovieList.layoutManager = layoutManager
        //dialog = SpotsDialog.Builder().setCancelable(true).setContext(this).build()
        getAllMovieList()
    }
    private fun getAllMovieList() {
        //dialog.show()
        mService.getMovieList().enqueue(object : Callback<MutableList<Movie>> {
            override fun onFailure(call: Call<MutableList<Movie>>, t: Throwable) {

            }

            override fun onResponse(call: Call<MutableList<Movie>>, response: Response<MutableList<Movie>>) {
                adapter = MyMovieAdapter(this@MainActivity,baseContext, response.body() as MutableList<Movie>)
                adapter.notifyDataSetChanged()
                recyclerMovieList.adapter = adapter

               //dialog.dismiss()
            }
        })
    }
}