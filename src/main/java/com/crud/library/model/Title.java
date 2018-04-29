package com.crud.library.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "TITLES")
public class Title {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "RELEASE_DATE")
    private int releaseDate;

    public Title(final String title, final String author, final int releaseDate) {
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
    }
}


