package pers.nefedov.demoshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.nefedov.demoshop.dto.HardDriveDto;
import pers.nefedov.demoshop.entities.HardDrive;
import pers.nefedov.demoshop.repositories.HardDriveRepository;
import pers.nefedov.demoshop.utils.HardDriveMappingUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HardDriveServiceImpl implements HardDriveService {
    @Autowired
    HardDriveRepository hardDriveRepository;
    @Autowired
    HardDriveMappingUtils hardDriveMappingUtils;

    @Transactional
    public void save(HardDriveDto hardDriveDto) {
        HardDrive hardDrive = hardDriveMappingUtils.mapToHardDriveEntity(hardDriveDto);
        hardDriveRepository.save(hardDrive);
    }

    public List<HardDriveDto> findAll() {
        return hardDriveRepository.findAll().stream().
                map(hardDriveMappingUtils::mapToHardDriveDto).collect(Collectors.toList());
    }

    public HardDriveDto findById(long id) {
        HardDrive foundMonitor = hardDriveRepository.findById(id).orElse(null);
        return foundMonitor != null ?
                hardDriveMappingUtils.mapToHardDriveDto(foundMonitor) :
                null;
    }

    @Transactional
    public int update(HardDriveDto hardDriveDto) {
        HardDrive newHardDrive = hardDriveMappingUtils.mapToHardDriveEntity(hardDriveDto);
        return hardDriveRepository.updateById(newHardDrive.getCapacity(), newHardDrive.getSerialNumber(),
                newHardDrive.getManufacturer(), newHardDrive.getPrice(),newHardDrive.getQuantity(), hardDriveDto.getId());
    }
}

