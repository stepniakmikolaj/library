package com.crud.library.controller;

import com.crud.library.service.TitleService;
import com.crud.library.dto.TitleDto;
import com.crud.library.mapper.TitleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Transactional

@RestController
@RequestMapping("library/title")
public class TitleController {

    @Autowired
    private TitleService titleService;
    @Autowired
    private TitleMapper titleMapper;

    @RequestMapping(method = RequestMethod.POST, value = "add", consumes = APPLICATION_JSON_VALUE)
    public void addTitle(@RequestBody TitleDto titleDto) {
        titleService.saveTitle(titleMapper.mapToTitle(titleDto));
    }

}
