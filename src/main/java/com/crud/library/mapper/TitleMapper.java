package com.crud.library.mapper;

import com.crud.library.dto.TitleDto;
import com.crud.library.model.Title;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TitleMapper {
    public Title mapToTitle(final TitleDto titleDto) {
        return new Title(
                titleDto.getTitle(),
                titleDto.getAuthor(),
                titleDto.getReleaseDate());
    }

    public TitleDto mapToTitleDto(final Title title) {
        return new TitleDto(
                title.getTitle(),
                title.getAuthor(),
                title.getReleaseDate());
    }

    public List<TitleDto> mapToTitleDtoList(final List<Title> titleList) {
        return titleList.stream()
                .map(this::mapToTitleDto)
                .collect(Collectors.toList());
    }
}
