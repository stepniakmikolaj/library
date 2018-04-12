package com.crud.library.mapper;

import com.crud.library.dto.TitleDto;
import com.crud.library.model.Title;
import org.springframework.stereotype.Component;

@Component
public class TitleMapper {
        public Title mapToTitle (final TitleDto titleDto) {
        return new Title(titleDto.getTitle(), titleDto.getAuthor(), titleDto.getReleaseDate());
    }
}
