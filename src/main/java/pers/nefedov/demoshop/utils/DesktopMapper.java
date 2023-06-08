package pers.nefedov.demoshop.utils;

import pers.nefedov.demoshop.dto.DesktopDto;
import pers.nefedov.demoshop.entities.Desktop;
import pers.nefedov.demoshop.entities.FormFactor;

public class DesktopMapper {
    private final DesktopDto dto;
    private final Desktop entity;

    public DesktopMapper(DesktopDto dto) {
        this.dto = dto;
        this.entity = mapToDesktopEntity(dto);
    }

    public DesktopMapper(Desktop entity) {
        this.entity = entity;
        this.dto = mapToDesktopDto(entity);
    }

    public DesktopDto getDto() {
        return dto;
    }

    public Desktop getEntity() {
        return entity;
    }

    private DesktopDto mapToDesktopDto(Desktop entity) {
        DesktopDto dto = new DesktopDto();
        dto.setFormFactor(entity.getFormFactor().toString());
        dto.setManufacturer(entity.getManufacturer());
        dto.setPrice(entity.getPrice());
        dto.setQuantity(entity.getQuantity());
        dto.setSerialNumber(entity.getSerialNumber());
        dto.setId(entity.getId());
        return dto;
    }
    private Desktop mapToDesktopEntity(DesktopDto dto) {
        Desktop entity = new Desktop();
        entity.setQuantity(dto.getQuantity());
        entity.setSerialNumber(dto.getSerialNumber());
        entity.setPrice(dto.getPrice());
        entity.setManufacturer(dto.getManufacturer());
        entity.setFormFactor(FormFactor.valueOf(dto.getFormFactor()));
        return entity;
    }
}
