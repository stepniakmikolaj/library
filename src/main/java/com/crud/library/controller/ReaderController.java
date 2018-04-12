package com.crud.library.controller;

import com.crud.library.dao.ReaderDao;
import com.crud.library.dto.ReaderDto;
import com.crud.library.mapper.ReaderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("library")
public class ReaderController {

    @Autowired
    ReaderDao readerDao;
    @Autowired
    ReaderMapper readerMapper;

    @RequestMapping(method = RequestMethod.POST, value = "addRader", consumes = APPLICATION_JSON_VALUE)
    public void addReader(@RequestBody ReaderDto readerDto) {
        readerDao.save(readerMapper.mapToReader(readerDto));
    }

}
