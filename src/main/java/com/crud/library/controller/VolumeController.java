package com.crud.library.controller;

import com.crud.library.dto.VolumeDto;
import com.crud.library.model.Status;
import com.crud.library.service.VolumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Transactional
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("library")
public class VolumeController {

    @Autowired
    private VolumeService volumeService;



    @RequestMapping(method = RequestMethod.GET, value = "volumes")
    public List<VolumeDto> getVolumes() {
        return volumeService.getAllVolumes();
    }

    @RequestMapping(method = RequestMethod.POST, value = "volume", consumes = APPLICATION_JSON_VALUE)
    public void addVolume(@RequestBody VolumeDto volumeDto) {
        volumeService.saveVolume(volumeDto);
    }

    @RequestMapping(method = RequestMethod.GET, value = "volume/{id}")
    public List<VolumeDto> getVolumeByIdTitle(@PathVariable() Long id) {
        return volumeService.findAllReadyByIdTitle(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "volume/{id}", consumes = APPLICATION_JSON_VALUE)
    public VolumeDto updateStatusVolume(@PathVariable Long id, @RequestBody VolumeDto volumeDto) throws NotFoundException {
        return volumeService.editVolumeStatus(id, volumeDto);
    }
}
