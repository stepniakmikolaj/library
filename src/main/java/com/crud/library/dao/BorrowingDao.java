package com.crud.library.dao;

import com.crud.library.model.Borrowing;
import org.springframework.data.repository.CrudRepository;

public interface BorrowingDao extends CrudRepository<Borrowing, Long> {
    Borrowing findBorrowingByIdTitle(Long idTitle);
}
