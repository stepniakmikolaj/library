package com.crud.library.mapper;

import com.crud.library.dto.BorrowingDto;
import com.crud.library.model.Borrowing;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BorrowingMapper {
    public Borrowing mapToBorrowing(final BorrowingDto borrowingDto) {
        return new Borrowing(
                borrowingDto.getIdVolume(),
                borrowingDto.getIdReader(),
                borrowingDto.getRented(),
                borrowingDto.getReturned());
    }

    public BorrowingDto mapToBorrowingDto(final Borrowing borrowing) {
        return new BorrowingDto(
                borrowing.getIdReader(),
                borrowing.getIdVolume(),
                borrowing.getDateOfRental(),
                borrowing.getDateOfReturn());
    }

    public List<BorrowingDto> mapToBorrowingDtoList(final List<Borrowing> borrowingList) {
        return borrowingList.stream()
                .map(this::mapToBorrowingDto)
                .collect(Collectors.toList());
    }
}
