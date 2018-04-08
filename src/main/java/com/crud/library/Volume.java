package com.crud.library;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "VOLUMES")
public class Volume {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private Long idCopy;

    @Column(name = "ID_TITLE")
    private Long idTitle;

    @Column(name = "STATUS")
    private String status;

    public Volume(final Long idTitle, final String status) {
        this.idTitle = idTitle;
        this.status = status;
    }
}
