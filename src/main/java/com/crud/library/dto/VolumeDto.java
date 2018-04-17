package com.crud.library.dto;

import com.crud.library.model.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VolumeDto {
    private Long idTitle;
    private Status status;
}
