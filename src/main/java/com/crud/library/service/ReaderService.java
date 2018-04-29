package com.crud.library.service;

import com.crud.library.dto.ReaderDto;
import com.crud.library.mapper.ReaderMapper;
import com.crud.library.model.Reader;
import com.crud.library.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ReaderService {
    @Autowired
    private ReaderRepository readerRepository;
    @Autowired
    private ReaderMapper readerMapper;

    public ReaderDto saveReader(final ReaderDto readerDto) {
        Reader reader = readerMapper.mapToReader(readerDto);
        reader = readerRepository.save(reader);
        return readerMapper.mapToReaderDto(reader);
    }

    public List<ReaderDto> getAllReaders() {
        return readerMapper.mapToReaderDtoList(readerRepository.findAll());
    }
}
