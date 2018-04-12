package com.crud.library.dao;

import com.crud.library.model.Title;
import org.springframework.data.repository.CrudRepository;

public interface TitleDao extends CrudRepository<Title, Long> {
}
