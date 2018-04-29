package com.crud.library.service;

import com.crud.library.dto.TitleDto;
import com.crud.library.mapper.TitleMapper;
import com.crud.library.model.Title;
import com.crud.library.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class TitleService {
    @Autowired
    private TitleRepository titleRepository;
    @Autowired
    private TitleMapper titleMapper;

    public TitleDto saveTitle(final TitleDto titleDto) {
        Title title = titleMapper.mapToTitle(titleDto);
        title = titleRepository.save(title);
        return titleMapper.mapToTitleDto(title);
    }

    public List<TitleDto> getAllTitles() {
        return titleMapper.mapToTitleDtoList(titleRepository.findAll());
    }
}
