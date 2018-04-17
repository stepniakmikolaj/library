package com.crud.library.dao;

import com.crud.library.model.Borrowing;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BorrowingDao extends CrudRepository<Borrowing, Long> {
    @Override
    List<Borrowing> findAll();

    Optional<Borrowing> findById(Long id);

    @Override
    Borrowing save(Borrowing borrowing);
}
