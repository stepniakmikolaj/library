package com.crud.library;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity(name = "TITLES")
public class Title {

    @Id
    @NotNull
    @Column(name = "TITLE_ID", unique = true)
    private Long idTitle;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "RELEASE_DATE")
    private Date releaseDate;

    public Title(final String title, final String author, final Date releaseDate) {
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
    }
}


