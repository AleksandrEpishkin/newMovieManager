package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {
    Movie first = new Movie(1, "imageUrl1", "name1", "genre1");
    Movie second = new Movie(2, "imageUrl2", "name2", "genre2");
    Movie third = new Movie(3, "imageUrl3", "name3", "genre3");
    Movie fourth = new Movie(4, "imageUrl4", "name4", "genre4");
    Movie fifth = new Movie(5, "imageUrl5", "name5", "genre5");
    Movie sixth = new Movie(6, "imageUrl6", "name6", "genre6");
    Movie seventh = new Movie(7, "imageUrl7", "name7", "genre7");
    Movie eighth = new Movie(8, "imageUrl8", "name8", "genre8");
    Movie ninth = new Movie(9, "imageUrl9", "name9", "genre9");
    Movie tenth = new Movie(10, "imageUrl10", "name10", "genre10");
    Movie eleven = new Movie(11, "imageUrl11", "name11", "genre11");

    MovieManager manager = new MovieManager();

    @Test
    public void addNewMovie() {
        manager.save(first);
        manager.save(second);
        manager.save(third);

        Movie[] actual = manager.findAll();
        Movie[] expected = {first, second, third};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void findAllEmpty() {
        Movie[] actual = manager.findAll();
        Movie[] expected = {};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void findLastDefault() {
        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);
        manager.save(sixth);
        manager.save(seventh);
        manager.save(eighth);
        manager.save(ninth);
        manager.save(tenth);
        manager.save(eleven);


        Movie[] actual = manager.findLast();
        Movie[] expected = {eleven, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void findLast2Movie() {
        MovieManager manager = new MovieManager(2);
        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);

        Movie[] actual = manager.findLast();
        Movie[] expected = {fifth, fourth};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void findLastLimitOverLength() {

        MovieManager manager = new MovieManager(6);
        manager.save(first);
        manager.save(second);
        manager.save(third);

        Movie[] actual = manager.findLast();
        Movie[] expected = {third, second, first};

        Assertions.assertArrayEquals(actual, expected);

    }
}