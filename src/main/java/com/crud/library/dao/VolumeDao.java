package com.crud.library.dao;

import com.crud.library.model.Volume;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VolumeDao extends CrudRepository<Volume, Long> {
    List<Volume> findVolumeByIdTitle(Long idTitle);
    Volume findVolumeById(Long idTitle);
}
