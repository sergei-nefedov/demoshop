package pers.nefedov.demoshop.utils;

import org.springframework.stereotype.Service;
import pers.nefedov.demoshop.dto.DesktopDto;
import pers.nefedov.demoshop.entities.Desktop;
import pers.nefedov.demoshop.entities.FormFactor;

@Service
public class DesktopMappingUtils {
    public DesktopDto mapToDesktopDto(Desktop entity) {
        DesktopDto dto = new DesktopDto();
        dto.setFormFactor(entity.getFormFactor().toString());
        dto.setManufacturer(entity.getManufacturer());
        dto.setPrice(entity.getPrice());
        dto.setQuantity(entity.getQuantity());
        dto.setSerialNumber(entity.getSerialNumber());
        dto.setId(entity.getId());
        return dto;
    }
    public Desktop mapToDesktopEntity(DesktopDto dto) {
        Desktop entity = new Desktop();
        entity.setQuantity(dto.getQuantity());
        entity.setSerialNumber(dto.getSerialNumber());
        entity.setPrice(dto.getPrice());
        entity.setManufacturer(dto.getManufacturer());
        entity.setFormFactor(FormFactor.valueOf(dto.getFormFactor()));
        return entity;
    }
}
