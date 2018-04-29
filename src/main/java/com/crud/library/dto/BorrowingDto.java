package com.crud.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BorrowingDto {
    private Long idVolume;
    private Long idReader;
    private LocalDateTime rented;
    private LocalDateTime returned;
}
