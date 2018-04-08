package com.crud.library;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "LOANS")
public class Borrowing {

    @Id
    @NotNull
    @Column(name = "ID_VOLUME")
    private Long idVolume;

    @Id
    @NotNull
    @Column(name = "ID_READER")
    private Long idReader;

    @Column(name = "DATE_OF_RENTAL")
    private Date dateOfRental;

    @Column(name = "DATE_OF_RETURN")
    private Date dateOfReturn;

    public Borrowing(final Long idVolume, final Long idReader, final Date dateOfRental, final Date dateOfReturn){
        this.idVolume = idVolume;
        this.idReader = idReader;
        this.dateOfRental = dateOfRental;
        this.dateOfReturn = dateOfReturn;
    }
}
