package com.crud.library.controller;

import com.crud.library.service.BorrowingService;
import com.crud.library.dto.BorrowingDto;
import com.crud.library.mapper.BorrowingMapper;
import com.crud.library.model.Borrowing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Transactional
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("library/borrowing")
public class BorrowingController {

    @Autowired
    private BorrowingService borrowingService;

    @Autowired
    private BorrowingMapper borrowingMapper;

    @RequestMapping(method = RequestMethod.POST, value = "add", consumes = APPLICATION_JSON_VALUE)
    public void addBorrow(@RequestBody BorrowingDto borrowingDto) {
        borrowingService.saveBorrowing(new Borrowing(borrowingDto.getIdVolume(), borrowingDto.getIdReader(), Date.from(Instant.now()), Date.from(Instant.now().plus(90, ChronoUnit.DAYS))));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}/return")
    public BorrowingDto returnVolume(@PathVariable("id") Long id) {
        Optional<Borrowing> editedBorrowing = borrowingService.findById(id);
        editedBorrowing.ifPresent(e -> e.setDateOfReturn(Date.from(Instant.now())));
        return borrowingMapper.mapToBorrowingDto(borrowingService.saveBorrowing(editedBorrowing.get()));
    }
}
