package com.crud.library.service;

import com.crud.library.repository.BorrowingRepository;
import com.crud.library.model.Borrowing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class BorrowingService {
    @Autowired
    private BorrowingRepository borrowingRepository;

    public Borrowing saveBorrowing(final Borrowing borrowing) {
        return borrowingRepository.save(borrowing);
    }

    public Optional<Borrowing> findById(final Long id) {
        return borrowingRepository.findById(id);
    }
}
