package com.crud.library.service;

import com.crud.library.repository.ReaderRepository;
import com.crud.library.model.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class ReaderService {
    @Autowired
    private ReaderRepository readerRepository;

    public Reader saveReader(final Reader reader) {
        return readerRepository.save(reader);
    }
}
