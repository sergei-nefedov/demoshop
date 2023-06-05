package pers.nefedov.demoshop.utils;

import org.springframework.stereotype.Service;
import pers.nefedov.demoshop.dto.MonitorDto;
import pers.nefedov.demoshop.entities.Monitor;

@Service
public class MonitorMappingUtils {
    public MonitorDto mapToNotebookDto(Monitor entity) {
        MonitorDto dto = new MonitorDto();
        dto.setDiagonalSize(entity.getDiagonalSize());
        dto.setManufacturer(entity.getManufacturer());
        dto.setPrice(entity.getPrice());
        dto.setQuantity(entity.getQuantity());
        dto.setSerialNumber(entity.getSerialNumber());
        dto.setId(entity.getId());
        return dto;
    }
    public Monitor mapToNotebookEntity(MonitorDto dto) {
        Monitor entity = new Monitor();
        entity.setQuantity(dto.getQuantity());
        entity.setSerialNumber(dto.getSerialNumber());
        entity.setPrice(dto.getPrice());
        entity.setManufacturer(dto.getManufacturer());
        entity.setDiagonalSize(dto.getDiagonalSize());
        return entity;
    }
}
