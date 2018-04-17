package com.crud.library.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity(name = "READERS")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "SIGN_UP_DATE")
    private Date singUpDate;

    public Reader(final String firstName, final String lastName, final Date singUpDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.singUpDate = singUpDate;
    }
}
