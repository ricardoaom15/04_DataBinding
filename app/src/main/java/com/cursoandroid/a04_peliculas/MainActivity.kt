package com.cursoandroid.a04_peliculas

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.cursoandroid.a04_peliculas.adapter.MovieAdapter
import com.cursoandroid.a04_peliculas.model.Movie
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import java.util.*

class MainActivity : AppCompatActivity() {

    val adapter: MovieAdapter = MovieAdapter()
    val data:MutableList<Movie> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list.adapter = adapter
        adapter.onMovieSelected = this::goToDetail
        adapter.onFavoriteSelected = this::saveFavorite
        loadData()
    }

    fun loadData(){
        data.add(Movie("http://www.comingsoon.net/assets/uploads/2017/10/lastjediheader.jpg", "StarWars Episodio VIII", 170, Date(), ""))
        data.add(Movie("https://cdn.movieweb.com/img.news.tops/NEvQAF8mTk2Qzv_1_b/Justice-League-Movie-Runtime-Shortest-Dceu-Movie.jpg", "Justice League", 120, null, ""))
        data.add(Movie("https://static1.squarespace.com/static/51cdafc4e4b09eb676a64e68/t/5a0f5dac53450a86195b5733/1508258047949/coco_logo.jpg", null, 170, Date(), ""))
        adapter.data = data
    }

    fun goToDetail(position: Int){
        /*val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("movie", 2)
        startActivity(intent)*/
        startActivity<DetailActivity>("movie" to data[position])
    }

    fun saveFavorite(position: Int){
        toast("Favorito: ${data[position].name}")
    }
}
