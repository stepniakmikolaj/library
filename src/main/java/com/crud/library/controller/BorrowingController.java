package com.crud.library.controller;

import com.crud.library.dto.BorrowingDto;
import com.crud.library.service.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Transactional
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("library/borrowings")
public class BorrowingController {

    @Autowired
    private BorrowingService borrowingService;

    @RequestMapping(method = RequestMethod.GET)
    public List<BorrowingDto> getList() {
        return borrowingService.getAllBorrowings();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public void addBorrow(@RequestBody BorrowingDto borrowingDto) {
        borrowingService.saveBorrowing(borrowingDto);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public BorrowingDto returnBorrow(@RequestBody BorrowingDto borrowingDto) {
        return borrowingService.saveBorrowing(borrowingDto);
    }
}
