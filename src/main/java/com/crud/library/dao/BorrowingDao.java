package com.crud.library.dao;

import com.crud.library.Borrowing;
import com.crud.library.Volume;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BorrowingDao extends CrudRepository<Borrowing, Long> {
    Borrowing findVolumeByIdTitle(Long idTitle);
}
