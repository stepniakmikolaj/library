package com.crud.library;

import com.crud.library.dto.VolumeDto;
import com.crud.library.dto.BorrowingDto;
import com.crud.library.dto.ReaderDto;
import com.crud.library.dto.TitleDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LibraryMapper {

    public Reader mapToReader (final ReaderDto readerDto){
        return new Reader(readerDto.getFirstName(), readerDto.getLastName(), readerDto.getSingUpDate());
    }

    public ReaderDto mapToReaderDto (final Reader reader) {
        return new ReaderDto(reader.getFirstName(), reader.getLastName(), reader.getSingUpDate());
    }

    public Title mapToTitle (final TitleDto titleDto) {
        return new Title(titleDto.getTitle(), titleDto.getAuthor(), titleDto.getReleaseDate());
    }

    public Volume mapToVolume(final VolumeDto volumeDto) {
        return new Volume(volumeDto.getIdTitle(), volumeDto.getStatus());
    }

    public VolumeDto mapToVolumeDto(final Volume volume) {
        return new VolumeDto(volume.getIdTitle(), volume.getStatus());
    }

    public List<VolumeDto> mapToVolumeList(final List<Volume> volumeList) {
        return volumeList.stream().map(e -> new VolumeDto(e.getIdTitle(), e.getStatus())).collect(Collectors.toList());
    }

    public BorrowingDto mapToBorrowingDto(final Borrowing borrowing) {
        return new BorrowingDto(borrowing.getIdReader(), borrowing.getIdVolume(), borrowing.getDateOfRental(), borrowing.getDateOfReturn());
    }
}
