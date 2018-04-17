package com.crud.library.model;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "ID_TITLE")
    private Long idTitle;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private Status status;

    public Volume(final Long idTitle, final Status status) {
        this.idTitle = idTitle;
        this.status = status;
    }
}
