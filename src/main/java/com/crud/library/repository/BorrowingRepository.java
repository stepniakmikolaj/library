package com.crud.library.repository;

import com.crud.library.model.Borrowing;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BorrowingRepository extends CrudRepository<Borrowing, Long> {
    @Override
    List<Borrowing> findAll();

    Optional<Borrowing> findById(Long id);

    @Override
    Borrowing save(Borrowing borrowing);
}
