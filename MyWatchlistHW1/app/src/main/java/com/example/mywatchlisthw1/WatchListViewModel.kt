package com.example.mywatchlisthw1

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class WatchlistViewModel : ViewModel() {

    // State variables
    var watchlist = mutableStateListOf<WatchListElement>()
        private set

    var autoIncrementId by mutableStateOf(0)
        private set

    var isDialogOpen by mutableStateOf(false)
        private set

    var movieName by mutableStateOf("")

    init {
        val initialList = List(10) { i -> WatchListElement(i, "Movie # $i") }
        watchlist.addAll(initialList)
        autoIncrementId = (watchlist.maxOfOrNull { it.id } ?: 0) + 1
    }

    fun addMovie() {
        if (movieName.isNotEmpty()) {
            watchlist.add(WatchListElement(autoIncrementId, movieName))
            autoIncrementId++
            movieName = ""
            isDialogOpen = false
        }
    }

    fun removeMovie(movie: WatchListElement) {
        watchlist.remove(movie)
    }

    fun openDialog() {
        isDialogOpen = true
    }

    fun closeDialog() {
        isDialogOpen = false
    }

    fun updateMovieName(name: String) {
        movieName = name
    }
}
