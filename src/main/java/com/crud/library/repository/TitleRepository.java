package com.crud.library.repository;

import com.crud.library.model.Title;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TitleRepository extends CrudRepository<Title, Long> {
    @Override
    List<Title> findAll();
}
