package com.crud.library.dao;

import com.crud.library.model.Volume;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface VolumeDao extends CrudRepository<Volume, Long> {
    @Override
    List<Volume> findAll();

    Optional<Volume> findById(Long id);

    List<Volume> findAllByIdTitle(Long id);

    @Override
    Volume save(Volume volume);
}
