package pers.nefedov.demoshop.utils;

import pers.nefedov.demoshop.dto.NotebookDto;
import pers.nefedov.demoshop.entities.Notebook;

public class NotebookMapper {
    private final NotebookDto dto;
    private final Notebook entity;

    public NotebookMapper(NotebookDto dto) {
        this.dto = dto;
        this.entity = mapToNotebookEntity(dto);
    }

    public NotebookMapper(Notebook entity) {
        this.entity = entity;
        this.dto = mapToNotebookDto(entity);
    }

    public NotebookDto getDto() {
        return dto;
    }

    public Notebook getEntity() {
        return entity;
    }

    private NotebookDto mapToNotebookDto(Notebook entity) {
        NotebookDto dto = new NotebookDto();
        dto.setSize(entity.getSize());
        dto.setManufacturer(entity.getManufacturer());
        dto.setPrice(entity.getPrice());
        dto.setQuantity(entity.getQuantity());
        dto.setSerialNumber(entity.getSerialNumber());
        dto.setId(entity.getId());
        return dto;
    }
    private Notebook mapToNotebookEntity(NotebookDto dto) {
        Notebook entity = new Notebook();
        entity.setQuantity(dto.getQuantity());
        entity.setSerialNumber(dto.getSerialNumber());
        entity.setPrice(dto.getPrice());
        entity.setManufacturer(dto.getManufacturer());
        entity.setSize(dto.getSize());
        return entity;
    }
}
