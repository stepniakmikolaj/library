package com.crud.library.service;

import com.crud.library.repository.VolumeRepository;
import com.crud.library.model.Volume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class VolumeService {
    @Autowired
    private VolumeRepository volumeRepository;

    public Volume saveVolume(final Volume volume) {
        return volumeRepository.save(volume);
    }

    public Optional<Volume> findVolume(final Long id) {
        return volumeRepository.findById(id);
    }

    public List<Volume> findAllByIdTitle(Long idTitle) {
        return volumeRepository.findAllByIdTitle(idTitle);
    }
}
