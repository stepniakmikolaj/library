package com.crud.library.dao;

import com.crud.library.model.Reader;
import org.springframework.data.repository.CrudRepository;

public interface ReaderDao extends CrudRepository<Reader, Long> {
}
