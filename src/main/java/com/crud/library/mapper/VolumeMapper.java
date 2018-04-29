package com.crud.library.mapper;

import com.crud.library.dto.VolumeDto;
import com.crud.library.model.Volume;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VolumeMapper {
    public Volume mapToVolume(final VolumeDto volumeDto) {
        return new Volume(
                volumeDto.getIdTitle(),
                volumeDto.getStatus());
    }

    public VolumeDto mapToVolumeDto(final Volume volume) {
        return new VolumeDto(
                volume.getIdTitle(),
                volume.getStatus());
    }

    public List<VolumeDto> mapToVolumeDtoList(final List<Volume> volumeList) {
        return volumeList.stream()
                .map(this::mapToVolumeDto)
                .collect(Collectors.toList());
    }
}
