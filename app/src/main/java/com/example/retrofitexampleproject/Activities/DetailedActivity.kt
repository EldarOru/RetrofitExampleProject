package com.example.retrofitexampleproject.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Fade
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.retrofitexampleproject.Model.Movie
import com.example.retrofitexampleproject.R
import com.squareup.picasso.Picasso

class DetailedActivity : AppCompatActivity() {
    lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        val fade = Fade()
        val decor: View = window.decorView
        fade.excludeTarget(decor.findViewById(R.id.action_bar_container) as View,true)
        fade.excludeTarget(android.R.id.statusBarBackground,true)
        fade.excludeTarget(android.R.id.navigationBarBackground,true)
        window.enterTransition = fade
        window.exitTransition = fade

        val intent = intent
        val movie: Movie? = intent.getParcelableExtra<Movie>("Object")
        //Toast.makeText(this, imageURL, Toast.LENGTH_SHORT).show()
        setView(movie)

    }

    private fun setView(movie: Movie?){
        imageView = findViewById(R.id.detailed_image)
        Picasso.get().load(movie?.imageurl).into(imageView)
        findViewById<TextView>(R.id.name).text = movie?.name
    }
}