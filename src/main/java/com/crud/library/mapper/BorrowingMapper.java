package com.crud.library.mapper;

import com.crud.library.dto.BorrowingDto;
import com.crud.library.model.Borrowing;
import org.springframework.stereotype.Component;

@Component
public class BorrowingMapper {
        public BorrowingDto mapToBorrowingDto(final Borrowing borrowing) {
        return new BorrowingDto(borrowing.getIdReader(), borrowing.getIdVolume(), borrowing.getDateOfRental(), borrowing.getDateOfReturn());
    }
}
