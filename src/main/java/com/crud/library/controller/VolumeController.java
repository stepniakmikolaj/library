package com.crud.library.controller;

import com.crud.library.dao.VolumeDao;
import com.crud.library.dto.VolumeDto;
import com.crud.library.mapper.VolumeMapper;
import com.crud.library.model.Volume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("library")
public class VolumeController {

    @Autowired
    VolumeDao volumeDao;
    @Autowired
    VolumeMapper volumeMapper;

    @RequestMapping(method = RequestMethod.POST, value = "addVolume", consumes = APPLICATION_JSON_VALUE)
    public void addVolume(@RequestBody VolumeDto volumeDto) {
        volumeDao.save(volumeMapper.mapToVolume(volumeDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateVolume", consumes = APPLICATION_JSON_VALUE)
    public VolumeDto updateVolume(@RequestBody VolumeDto volumeDto) {
        Volume editedVolume = volumeDao.findVolumeById(volumeDto.getIdTitle());
        editedVolume.setStatus(volumeDto.getStatus());
        return volumeMapper.mapToVolumeDto(volumeDao.save(editedVolume));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getVolumes")
    public List<VolumeDto> getVolumes(@RequestParam Long IdTitle) {
        return volumeMapper.mapToVolumeList(volumeDao.findVolumeByIdTitle(IdTitle));
    }
}
