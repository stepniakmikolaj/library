package com.crud.library;

import com.crud.library.dao.VolumeDao;
import com.crud.library.dao.BorrowingDao;
import com.crud.library.dao.ReaderDao;
import com.crud.library.dao.TitleDao;
import com.crud.library.dto.BorrowingDto;
import com.crud.library.dto.TitleDto;
import com.crud.library.dto.VolumeDto;
import com.crud.library.dto.ReaderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("library")
public class LibraryController {

    @Autowired
    ReaderDao readerDao;
    @Autowired
    TitleDao titleDao;
    @Autowired
    VolumeDao volumeDao;
    @Autowired
    BorrowingDao borrowingDao;
    @Autowired
    LibraryMapper libraryMapper;

    @RequestMapping(method = RequestMethod.POST, value = "addRader", consumes = APPLICATION_JSON_VALUE)
    public void addReader(@RequestBody ReaderDto readerDto) {
        readerDao.save(libraryMapper.mapToReader(readerDto));
    }

    @RequestMapping(method = RequestMethod.POST, value = "addTitle" , consumes = APPLICATION_JSON_VALUE)
    public void addTitle(@RequestBody TitleDto titleDto) {
        titleDao.save(libraryMapper.mapToTitle(titleDto));
    }

    @RequestMapping(method = RequestMethod.POST, value = "addVolume", consumes = APPLICATION_JSON_VALUE)
    public void addVolume(@RequestBody VolumeDto volumeDto) {
        volumeDao.save(libraryMapper.mapToVolume(volumeDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateVolume", consumes = APPLICATION_JSON_VALUE)
    public VolumeDto updateVolume(@RequestBody VolumeDto volumeDto) {
        Volume editedVolume = volumeDao.findVolumeById(volumeDto.getIdTitle());
        editedVolume.setStatus(volumeDto.getStatus());
        return libraryMapper.mapToVolumeDto(volumeDao.save(editedVolume));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getVolumes")
    public List<VolumeDto> getVolumes(@RequestParam Long IdTitle) {
        return libraryMapper.mapToVolumeList(volumeDao.findVolumeByIdTitle(IdTitle));
    }

    @RequestMapping(method = RequestMethod.POST, value = "borrowingVolume")
    public void borrowingVolume(@RequestParam Long idReader, Long idVolume) {
        borrowingDao.save(new Borrowing(idReader, idVolume, Date.from(Instant.now()), Date.from(Instant.now().plus(90, ChronoUnit.DAYS))));
    }

    @RequestMapping(method = RequestMethod.POST, value = "returnVolume")
    public BorrowingDto returnVolume (@RequestParam Long idVolume) {
        Borrowing editedBorrowing = borrowingDao.findVolumeByIdTitle(idVolume);
        editedBorrowing.setDateOfReturn(Date.from(Instant.now()));
        return libraryMapper.mapToBorrowingDto(borrowingDao.save(editedBorrowing));
    }
}
