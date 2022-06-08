package ru.netology.manager;


public class MovieManager {

    private Movie[] movies = new Movie[0];
    private int maxNumberMovies;


    public MovieManager() {
        this.maxNumberMovies = 10;
    }

    public MovieManager(int maxNumberMovies) {
        this.maxNumberMovies = maxNumberMovies;
    }

    public void add(Movie newMovie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = newMovie;
        movies = tmp;
    }

    public Movie[] findAll() {
        return movies;
    }

    public Movie[] findLast() {

        if (maxNumberMovies < movies.length) {
            Movie[] resultLength = new Movie[maxNumberMovies];
            for (int i = 0; i < maxNumberMovies; i++) {
                int index = movies.length - i - 1;
                resultLength[i] = movies[index];
            }
            return resultLength;
        }
        else {
            Movie[] resultLength = new Movie[movies.length];
            for (int i = 0; i < movies.length; i++) {
                int index = movies.length - i - 1;
                resultLength[i] = movies[index];
            }
            return resultLength;
        }
    }

}
