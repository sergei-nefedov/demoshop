package pers.nefedov.demoshop.facades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.nefedov.demoshop.dto.HardDriveDto;
import pers.nefedov.demoshop.services.HardDriveService;

import java.util.List;

@Service
public class HardDriveFacadeImpl implements HardDriveFacade {
    @Autowired
    HardDriveService hardDriveService;

    @Override
    public void save(HardDriveDto hardDriveDto) {
        hardDriveService.save(hardDriveDto);
    }

    @Override
    public List<HardDriveDto> findAll() {
        return hardDriveService.findAll();
    }

    @Override
    public HardDriveDto findById(long id) {
        return hardDriveService.findById(id);
    }

    @Override
    public int update(HardDriveDto hardDriveDto) {
        return hardDriveService.update(hardDriveDto);
    }
}
