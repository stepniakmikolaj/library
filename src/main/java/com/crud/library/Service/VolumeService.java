package com.crud.library.Service;

import com.crud.library.dao.VolumeDao;
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
    VolumeDao volumeDao;

    public Volume saveVolume(final Volume volume) {
        return volumeDao.save(volume);
    }

    public Optional<Volume> findVolume(final Long id) {
        return volumeDao.findById(id);
    }

    public List<Volume> findAllByIdTitle(Long idTitle) {
        return volumeDao.findAllByIdTitle(idTitle);
    }
}
