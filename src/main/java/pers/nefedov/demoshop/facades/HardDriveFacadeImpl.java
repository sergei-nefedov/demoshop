package pers.nefedov.demoshop.facades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.nefedov.demoshop.dto.HardDriveDto;
import pers.nefedov.demoshop.services.HardDriveService;
import pers.nefedov.demoshop.utils.HardDriveMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HardDriveFacadeImpl implements HardDriveFacade {
    @Autowired
    HardDriveService hardDriveService;

    @Override
    public void save(HardDriveDto hardDriveDto) {
        hardDriveService.save(new HardDriveMapper(hardDriveDto));
    }

    @Override
    public List<HardDriveDto> findAll() {
        return hardDriveService.findAll().stream().map(HardDriveMapper::getDto).collect(Collectors.toList());
    }

    @Override
    public HardDriveDto findById(long id) {
        return hardDriveService.findById(id).getDto();
    }

    @Override
    public int update(HardDriveDto hardDriveDto) {
        return hardDriveService.update(new HardDriveMapper(hardDriveDto));
    }
}
