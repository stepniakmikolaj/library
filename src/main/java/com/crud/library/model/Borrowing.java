package com.crud.library.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "BORROWINGS")
public class Borrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "ID_VOLUME")
    private Long idVolume;

    @NotNull
    @Column(name = "ID_READER")
    private Long idReader;

    @Column(name = "DATE_OF_RENTAL")
    private LocalDateTime dateOfRental;

    @Column(name = "DATE_OF_RETURN")
    private LocalDateTime dateOfReturn;

    public Borrowing(final Long idVolume, final Long idReader, final LocalDateTime dateOfRental, final LocalDateTime dateOfReturn) {
        this.idVolume = idVolume;
        this.idReader = idReader;
        this.dateOfRental = dateOfRental;
        this.dateOfReturn = dateOfReturn;
    }
}
