package com.crud.library.service;

import com.crud.library.dto.BorrowingDto;
import com.crud.library.mapper.BorrowingMapper;
import com.crud.library.model.Borrowing;
import com.crud.library.repository.BorrowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class BorrowingService {
    @Autowired
    private BorrowingRepository borrowingRepository;
    @Autowired
    private BorrowingMapper borrowingMapper;

    public List<BorrowingDto> getAllBorrowings() {
        return borrowingMapper.mapToBorrowingDtoList(borrowingRepository.findAll());
    }

    public BorrowingDto saveBorrowing(final BorrowingDto borrowingDto) {
        Borrowing borrowing = borrowingRepository.save(new Borrowing(borrowingDto.getIdVolume(), borrowingDto.getIdReader(), LocalDateTime.now(), LocalDateTime.now().plusDays(90)));
        if (null != borrowing) {
            return this.borrowingMapper.mapToBorrowingDto(borrowing);
        }
        return null;
    }
}
