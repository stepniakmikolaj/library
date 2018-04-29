package com.crud.library.repository;

import com.crud.library.model.Volume;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface VolumeRepository extends CrudRepository<Volume, Long> {
    @Override
    List<Volume> findAll();

    Optional<Volume> findById(Long id);

    List<Volume> findAllByIdTitle(Long id);

}
