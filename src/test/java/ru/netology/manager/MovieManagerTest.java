package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {

    @Test
    void shouldAddNewMovies() {

        MovieManager manager = new MovieManager();
        int totalMovies = 15;
        Movie[] expectedMovies = new Movie[totalMovies];

        for (int i = 0; i < totalMovies; i++) {
            String number = Integer.toString(i);
            Movie newMovie = new Movie(i, "urlMovie" + number, "Movie" + number, "genre" + number);
            manager.add(newMovie);
            expectedMovies[i] = newMovie;
        }

        Movie[] actual = manager.findAll();
        Movie[] expected = expectedMovies;

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowAllMovies() {

        MovieManager manager = new MovieManager();
        Movie[] actual = manager.findAll();
        Movie[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldViewLast10Movies() {

        MovieManager manager = new MovieManager();
        int totalMovies = 35;
        Movie[] expectedMovies = new Movie[totalMovies];
        for (int i = 0; i < totalMovies; i++) {
            String number = Integer.toString(i);
            Movie newMovie = new Movie(i, "urlMovie" + number, "Movie" + number, "genre" + number);
            manager.add(newMovie);
            expectedMovies[i] = newMovie;
        }

        Movie[] actual = manager.findLast();
        Movie[] expected = {expectedMovies[34], expectedMovies[33], expectedMovies[32], expectedMovies[31], expectedMovies[30], expectedMovies[29], expectedMovies[28], expectedMovies[27], expectedMovies[26], expectedMovies[25]};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldViewLast5Movies() {

        MovieManager manager = new MovieManager(5);
        int totalMovies = 19;
        Movie[] expectedMovies = new Movie[totalMovies];
        for (int i = 0; i < totalMovies; i++) {
            String number = Integer.toString(i);
            Movie newMovie = new Movie(i, "urlMovie" + number, "Movie" + number, "genre" + number);
            manager.add(newMovie);
            expectedMovies[i] = newMovie;
        }

        Movie[] actual = manager.findLast();
        Movie[] expected = {expectedMovies[18], expectedMovies[17], expectedMovies[16], expectedMovies[15], expectedMovies[14]};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldViewFewerRecentMovies() {

        MovieManager manager = new MovieManager();
        int totalMovies = 3;
        Movie[] expectedMovies = new Movie[totalMovies];

        for (int i = 0; i < totalMovies; i++) {
            String number = Integer.toString(i);
            Movie newMovie = new Movie(i, "urlMovie" + number, "Movie" + number, "genre" + number);
            manager.add(newMovie);
            expectedMovies[i] = newMovie;
        }

        Movie[] actual = manager.findLast();
        Movie[] expected = {expectedMovies[2], expectedMovies[1], expectedMovies[0]};

        Assertions.assertArrayEquals(expected, actual);
    }
}