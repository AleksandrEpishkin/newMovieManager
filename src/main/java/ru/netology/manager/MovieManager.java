package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
//@NoArgsConstructor
@Data
public class MovieManager {
    private Movie[] items = new Movie[0];
    private int maxLimit = 10;

    public MovieManager(int limit) {
        this.maxLimit = limit;
    }

    public MovieManager() {
    }

    public void save(Movie item) {
        int length = items.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(items,0,tmp,0,items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Movie[] findAll() {
        return items;
    }

    public Movie[] findLast() {
        int resultLenght;
        if (maxLimit > items.length) {
            resultLenght = items.length;
        } else {
            resultLenght = maxLimit;
        }
        Movie[] result = new Movie[resultLenght];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }

        return result;
    }

}

