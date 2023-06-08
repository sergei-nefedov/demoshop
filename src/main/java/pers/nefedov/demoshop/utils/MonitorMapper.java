package pers.nefedov.demoshop.utils;

import pers.nefedov.demoshop.dto.MonitorDto;
import pers.nefedov.demoshop.entities.Monitor;

public class MonitorMapper {
    private final MonitorDto dto;
    private final Monitor entity;

    public MonitorMapper(MonitorDto dto) {
        this.dto = dto;
        this.entity = mapToMonitorEntity(dto);
    }

    public MonitorMapper(Monitor entity) {
        this.entity = entity;
        this.dto = mapToMonitorDto(entity);
    }

    public MonitorDto getDto() {
        return dto;
    }

    public Monitor getEntity() {
        return entity;
    }

    private MonitorDto mapToMonitorDto(Monitor entity) {
        MonitorDto dto = new MonitorDto();
        dto.setDiagonalSize(entity.getDiagonalSize());
        dto.setManufacturer(entity.getManufacturer());
        dto.setPrice(entity.getPrice());
        dto.setQuantity(entity.getQuantity());
        dto.setSerialNumber(entity.getSerialNumber());
        dto.setId(entity.getId());
        return dto;
    }
    private Monitor mapToMonitorEntity(MonitorDto dto) {
        Monitor entity = new Monitor();
        entity.setQuantity(dto.getQuantity());
        entity.setSerialNumber(dto.getSerialNumber());
        entity.setPrice(dto.getPrice());
        entity.setManufacturer(dto.getManufacturer());
        entity.setDiagonalSize(dto.getDiagonalSize());
        return entity;
    }
}
