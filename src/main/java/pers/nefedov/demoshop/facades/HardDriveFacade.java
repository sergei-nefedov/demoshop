package pers.nefedov.demoshop.facades;

import pers.nefedov.demoshop.dto.HardDriveDto;

import java.util.List;

public interface HardDriveFacade {
    public HardDriveDto save(HardDriveDto hardDriveDto);
    public List<HardDriveDto> findAll();
    public HardDriveDto findById(long id);
    public int update(HardDriveDto hardDriveDto);

    public void deleteAll();
}
