package com.crud.library.controller;

import com.crud.library.dto.VolumeDto;
import com.crud.library.service.VolumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Transactional
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("library/volume")
public class VolumeController {

    @Autowired
    private VolumeService volumeService;
//    @Autowired
//    private VolumeMapper volumeMapper;

    @RequestMapping(method = RequestMethod.GET, value = "list")
    public List<VolumeDto> getVolumes() {
        return volumeService.getAllVolumes();
    }

    @RequestMapping(method = RequestMethod.POST, value = "add", consumes = APPLICATION_JSON_VALUE)
    public void addVolume(@RequestBody VolumeDto volumeDto) {
        volumeService.saveVolume(volumeDto);
    }

//    @RequestMapping(method = RequestMethod.PUT, value = "update", consumes = APPLICATION_JSON_VALUE)
//    public VolumeDto updateVolume(@RequestBody VolumeDto volumeDto) throws NotFoundException {
//        Optional<Volume> volume = volumeService.findVolume(volumeDto.getId());
//        volume.ifPresent(v -> v.setStatus(volumeDto.getStatus()));
//        return volumeMapper.mapToVolumeDto(volumeService.saveVolume(volume.get()));
//        return volumeService.saveVolume(volumeDto);
//    }

    @RequestMapping(method = RequestMethod.GET, value = "get")
    public List<VolumeDto> getVolumesByIdTitle(@RequestParam("idTitle") Long id) {
        return volumeService.findAllByIdTitle(id);
    }
}
