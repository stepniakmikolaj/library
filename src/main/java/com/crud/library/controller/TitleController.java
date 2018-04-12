package com.crud.library.controller;

import com.crud.library.dao.TitleDao;
import com.crud.library.dto.TitleDto;
import com.crud.library.mapper.TitleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("library")
public class TitleController {

    @Autowired
    TitleDao titleDao;
    @Autowired
    TitleMapper titleMapper;

    @RequestMapping(method = RequestMethod.POST, value = "addTitle", consumes = APPLICATION_JSON_VALUE)
    public void addTitle(@RequestBody TitleDto titleDto) {
        titleDao.save(titleMapper.mapToTitle(titleDto));
    }

}
