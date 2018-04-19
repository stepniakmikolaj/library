package com.crud.library.service;

import com.crud.library.repository.TitleRepository;
import com.crud.library.model.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class TitleService {
    @Autowired
    private TitleRepository titleRepository;

    public Title saveTitle(final Title title) {
        return titleRepository.save(title);
    }
}
