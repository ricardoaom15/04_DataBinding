package com.cursoandroid.a04_peliculas.adapter

import android.content.Context
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cursoandroid.a04_peliculas.R
import com.cursoandroid.a04_peliculas.model.Movie
import com.cursoandroid.a04_peliculas.util.inflate
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.template_movie.view.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by RicardoAndrés on 06/12/2017.
 */
class MovieAdapter: RecyclerView.Adapter<MovieHolder>() {

    val data: List<Movie> = emptyList()

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder =
            MovieHolder(parent.inflate(R.layout.template_movie))

    override fun getItemCount(): Int = data.size

}

class MovieHolder(view: View): RecyclerView.ViewHolder(view){

    val dateFormat: SimpleDateFormat = SimpleDateFormat("yyyy/MM/dd",Locale.getDefault())
    val contex: Context = itemView.context

    fun bind(movie: Movie){
        itemView.name.text = movie.name
        itemView.duration.text = contex.getString(R.string.duration, movie.duration)
        itemView.release.text = dateFormat.format(movie.releaseDate)
        Picasso.with(contex)
                .load(Uri.parse(movie.img))
                .into(itemView.img)

    }
}