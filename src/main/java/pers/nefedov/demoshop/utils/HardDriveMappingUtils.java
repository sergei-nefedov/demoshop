package pers.nefedov.demoshop.utils;

import org.springframework.stereotype.Service;
import pers.nefedov.demoshop.dto.HardDriveDto;
import pers.nefedov.demoshop.entities.HardDrive;

@Service
public class HardDriveMappingUtils {
    public HardDriveDto mapToHardDriveDto(HardDrive entity) {
        HardDriveDto dto = new HardDriveDto();
        dto.setCapacity(entity.getCapacity());
        dto.setManufacturer(entity.getManufacturer());
        dto.setPrice(entity.getPrice());
        dto.setQuantity(entity.getQuantity());
        dto.setSerialNumber(entity.getSerialNumber());
        dto.setId(entity.getId());
        return dto;
    }
    public HardDrive mapToHardDriveEntity(HardDriveDto dto) {
        HardDrive entity = new HardDrive();
        entity.setQuantity(dto.getQuantity());
        entity.setSerialNumber(dto.getSerialNumber());
        entity.setPrice(dto.getPrice());
        entity.setManufacturer(dto.getManufacturer());
        entity.setCapacity(dto.getCapacity());
        return entity;
    }
}
