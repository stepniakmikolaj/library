package com.crud.library.Service;

import com.crud.library.dao.ReaderDao;
import com.crud.library.model.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class ReaderService {
    @Autowired
    ReaderDao readerDao;

    public Reader saveReader(final Reader reader) {
        return readerDao.save(reader);
    }
}
