package com.crud.library.repository;

import com.crud.library.model.Title;
import org.springframework.data.repository.CrudRepository;

public interface TitleRepository extends CrudRepository<Title, Long> {
}
