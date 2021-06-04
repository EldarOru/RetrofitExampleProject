package com.example.retrofitexampleproject.Adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitexampleproject.Activities.DetailedActivity
import com.example.retrofitexampleproject.Activities.MainActivity
import com.example.retrofitexampleproject.Model.Movie
import com.example.retrofitexampleproject.R
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class MyMovieAdapter(private val activity: Activity,private val context: Context, private val movieList: MutableList<Movie>):RecyclerView.Adapter<MyMovieAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = movieList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listItem = movieList[position]
        holder.bind(listItem, activity)

        Picasso.get().load(movieList[position].imageurl).into(holder.image)
        holder.txt_name.text = movieList[position].name
        holder.txt_team.text = "Team: " + movieList[position].team
        holder.txt_createdby.text = "Creator: " + movieList[position].createdby
        holder.txt_description.text = movieList[position].bio
    }

    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.findViewById(R.id.image_movie)
        val txt_name: TextView = itemView.findViewById(R.id.txt_name)
        val txt_team: TextView = itemView.findViewById(R.id.txt_team)
        val txt_createdby: TextView = itemView.findViewById(R.id.txt_createdby)
        val txt_description: TextView = itemView.findViewById(R.id.txt_description)

        fun bind(listItem: Movie, context: Activity) {
            itemView.setOnClickListener {
                val intent = Intent(it.context,DetailedActivity::class.java)
                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(context,image,("transition_image"))
                intent.putExtra("Object",listItem)
                context.startActivity(intent,options.toBundle())
            }
        }
    }
}
