package com.crud.library.controller;

import com.crud.library.dto.TitleDto;
import com.crud.library.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Transactional

@RestController
@RequestMapping("library")
public class TitleController {

    @Autowired
    private TitleService titleService;

    @RequestMapping(method = RequestMethod.POST, value = "title", consumes = APPLICATION_JSON_VALUE)
    public void addTitle(@RequestBody TitleDto titleDto) {
        titleService.saveTitle(titleDto);
    }

    @RequestMapping(method = RequestMethod.GET, value = "titles")
    public List<TitleDto> getTitles() {
        return titleService.getAllTitles();
    }

}
