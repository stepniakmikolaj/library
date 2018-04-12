package com.crud.library.controller;

import com.crud.library.model.Borrowing;
import com.crud.library.mapper.BorrowingMapper;
import com.crud.library.dao.BorrowingDao;
import com.crud.library.dto.BorrowingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@RestController
@RequestMapping("library")
public class BorrowingController {

    @Autowired
    BorrowingDao borrowingDao;
    @Autowired
    BorrowingMapper borrowingMapper;

    @RequestMapping(method = RequestMethod.POST, value = "borrowingVolume")
    public void borrowingVolume(@RequestParam Long idReader, Long idVolume) {
        borrowingDao.save(new Borrowing(idReader, idVolume, Date.from(Instant.now()), Date.from(Instant.now().plus(90, ChronoUnit.DAYS))));
    }

    @RequestMapping(method = RequestMethod.POST, value = "returnVolume")
    public BorrowingDto returnVolume(@RequestParam Long idVolume) {
        Borrowing editedBorrowing = borrowingDao.findBorrowingByIdTitle(idVolume);
        editedBorrowing.setDateOfReturn(Date.from(Instant.now()));
        return borrowingMapper.mapToBorrowingDto(borrowingDao.save(editedBorrowing));
    }
}
