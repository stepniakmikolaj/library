package com.crud.library.dao;

import com.crud.library.model.Reader;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ReaderDao extends CrudRepository<Reader, Long> {
    @Override
    List<Reader> findAll();

    Optional<Reader> findById(Long id);

    @Override
    Reader save(Reader reader);

    void deleteById(Long id);
}
