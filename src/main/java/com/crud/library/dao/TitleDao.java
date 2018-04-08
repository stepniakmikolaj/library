package com.crud.library.dao;

import com.crud.library.Title;
import org.springframework.data.repository.CrudRepository;

public interface TitleDao extends CrudRepository<Title, Long> {
}
