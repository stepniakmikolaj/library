package com.crud.library.Service;

import com.crud.library.dao.BorrowingDao;
import com.crud.library.model.Borrowing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class BorrowingService {
    @Autowired
    BorrowingDao borrowingDao;

    public Borrowing saveBorrowing(final Borrowing borrowing) {
        return borrowingDao.save(borrowing);
    }

    public Optional<Borrowing> findById(final Long id) {
        return borrowingDao.findById(id);
    }
}
