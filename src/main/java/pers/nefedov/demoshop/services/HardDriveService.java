package pers.nefedov.demoshop.services;

import org.springframework.stereotype.Component;
import pers.nefedov.demoshop.dto.HardDriveDto;

import java.util.List;

@Component
public interface HardDriveService {
    public void save(HardDriveDto hardDriveDto);
    public List<HardDriveDto> findAll();
    public HardDriveDto findById(long id);
    public int update(HardDriveDto hardDriveDto);
}
