package com.example.mobicomposeapp.utils


// OBJECT funciona como un sigleton,cada vez que usemos appConstants accedera desde un mismo objeto, es decir lo crea solo una vez
object AppConstants {

    //API
    const val BASE_URL="https://api.themoviedb.org/3/"
    const val API_KEY="73d92f173ff8ba5d9939ae435ce464ea"
    const val LARGE_IMAGE_URL = "https://image.tmdb.org/t/p/w500"
    const val SMALL_IMAGE_URL = "https://image.tmdb.org/t/p/w200"
}