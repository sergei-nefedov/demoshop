package pers.nefedov.demoshop.utils;

import pers.nefedov.demoshop.dto.HardDriveDto;
import pers.nefedov.demoshop.entities.HardDrive;

public class HardDriveMapper {
    private final HardDriveDto dto;
    private final HardDrive entity;

    public HardDriveMapper(HardDriveDto dto) {
        this.dto = dto;
        this.entity = mapToHardDriveEntity(dto);
    }

    public HardDriveMapper(HardDrive entity) {
        this.entity = entity;
        this.dto = mapToHardDriveDto(entity);
    }

    public HardDriveDto getDto() {
        return dto;
    }

    public HardDrive getEntity() {
        return entity;
    }

    private HardDriveDto mapToHardDriveDto(HardDrive entity) {
        HardDriveDto dto = new HardDriveDto();
        dto.setCapacity(entity.getCapacity());
        dto.setManufacturer(entity.getManufacturer());
        dto.setPrice(entity.getPrice());
        dto.setQuantity(entity.getQuantity());
        dto.setSerialNumber(entity.getSerialNumber());
        dto.setId(entity.getId());
        return dto;
    }
    private HardDrive mapToHardDriveEntity(HardDriveDto dto) {
        HardDrive entity = new HardDrive();
        entity.setQuantity(dto.getQuantity());
        entity.setSerialNumber(dto.getSerialNumber());
        entity.setPrice(dto.getPrice());
        entity.setManufacturer(dto.getManufacturer());
        entity.setCapacity(dto.getCapacity());
        return entity;
    }
}
