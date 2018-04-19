package com.crud.library.controller;

import com.crud.library.service.VolumeService;
import com.crud.library.dto.VolumeDto;
import com.crud.library.mapper.VolumeMapper;
import com.crud.library.model.Status;
import com.crud.library.model.Volume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Transactional
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("library/volume")
public class VolumeController {

    @Autowired
    private VolumeService volumeService;
    @Autowired
    private VolumeMapper volumeMapper;

    @RequestMapping(method = RequestMethod.POST, value = "add", consumes = APPLICATION_JSON_VALUE)
    public void addVolume(@RequestBody VolumeDto volumeDto) {
        volumeService.saveVolume(volumeMapper.mapToVolume(volumeDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}/update", consumes = APPLICATION_JSON_VALUE)
    public VolumeDto updateVolume(@PathVariable("id") Long id, @RequestBody VolumeDto volumeDto) throws NotFoundException {
        Optional<Volume> volume = volumeService.findVolume(id);
        volume.ifPresent(v -> v.setStatus(volumeDto.getStatus()));
        return volumeMapper.mapToVolumeDto(volumeService.saveVolume(volume.get()));
    }

    @RequestMapping(method = RequestMethod.GET, value = "get")
    public List<VolumeDto> getVolumesByIdTitle(@RequestParam("idTitle") Long id) {
        final Status status = Status.READY;
        List<Volume> allByIdTitle = volumeService.findAllByIdTitle(id);
        List<Volume> filteredVolumes = allByIdTitle.stream()
                .filter(v -> v.getStatus().equals(status))
                .collect(Collectors.toList());
        return volumeMapper.mapToVolumeList(filteredVolumes);
    }
}
