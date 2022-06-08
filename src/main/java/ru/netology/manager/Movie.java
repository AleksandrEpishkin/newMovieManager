package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    private int id;
    private String imageUrl;
    private String name;
    private String genre;
}
