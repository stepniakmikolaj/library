package com.crud.library.service;

import com.crud.library.dto.VolumeDto;
import com.crud.library.mapper.VolumeMapper;
import com.crud.library.model.Status;
import com.crud.library.model.Volume;
import com.crud.library.repository.VolumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
public class VolumeService {
    @Autowired
    private VolumeRepository volumeRepository;
    @Autowired
    private VolumeMapper volumeMapper;

    public VolumeDto saveVolume(final VolumeDto volumeDto) {
        Volume volume = volumeMapper.mapToVolume(volumeDto);
        volume = volumeRepository.save(volume);
        return volumeMapper.mapToVolumeDto(volume);
    }

    public List<VolumeDto> findAllReadyByIdTitle(Long idTitle) {
        final Status status = Status.READY;
        List<Volume> allByIdTitle = volumeRepository.findAllByIdTitle(idTitle);
        List<Volume> filteredVolumes = allByIdTitle.stream()
                .filter(v -> v.getStatus().equals(status))
                .collect(Collectors.toList());
        return volumeMapper.mapToVolumeDtoList(filteredVolumes);
    }

    public List<VolumeDto> getAllVolumes() {
        return volumeMapper.mapToVolumeDtoList(volumeRepository.findAll());
    }

    public VolumeDto editVolumeStatus(Long id, VolumeDto volumeDto) {
        Optional<Volume> volume = volumeRepository.findById(id);
        volume.ifPresent(v -> v.setStatus(volumeDto.getStatus()));
        return volumeMapper.mapToVolumeDto(volumeRepository.save(volume.get()));
    }
}
