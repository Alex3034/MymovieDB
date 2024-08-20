package com.personalapps.mymoviedb.data

class MoviesRepository {

    suspend fun fetchPopularMovies(): List<Movie> =
        MoviesClient
            .instance
            .fetchPopularMovies("US")
            .results
            .map { it.toDomainModel() }
}

private fun RemoteMovie.toDomainModel(): Movie =
    Movie(
        id = id,
        title = title,
        poster = "https://image.tmdb.org/t/p/w185$posterPath",
    )