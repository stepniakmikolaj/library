package com.crud.library;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity(name = "READERS")
public class Reader {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long idReader;

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
