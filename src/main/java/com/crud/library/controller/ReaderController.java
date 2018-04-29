package com.crud.library.controller;

import com.crud.library.dto.ReaderDto;
import com.crud.library.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Transactional
@RestController
@RequestMapping("/library/reader")
public class ReaderController {

    @Autowired
    private ReaderService readerService;

    @RequestMapping(method = RequestMethod.GET, value = "list")
    public List<ReaderDto> getList() {
        return readerService.getAllReaders();
    }

    @RequestMapping(method = RequestMethod.POST, value = "add", consumes = APPLICATION_JSON_VALUE)
    public void addReader(@RequestBody ReaderDto readerDto) {
        readerService.saveReader(readerDto);
    }
}
