package pers.nefedov.demoshop.utils;

import org.springframework.stereotype.Service;
import pers.nefedov.demoshop.dto.NotebookDto;
import pers.nefedov.demoshop.entities.Notebook;

@Service
public class NotebookMappingUtils {
    public NotebookDto mapToNotebookDto(Notebook entity) {
        NotebookDto dto = new NotebookDto();
        dto.setSize(entity.getSize());
        dto.setManufacturer(entity.getManufacturer());
        dto.setPrice(entity.getPrice());
        dto.setQuantity(entity.getQuantity());
        dto.setSerialNumber(entity.getSerialNumber());
        dto.setId(entity.getId());
        return dto;
    }
    public Notebook mapToNotebookEntity(NotebookDto dto) {
        Notebook entity = new Notebook();
        entity.setQuantity(dto.getQuantity());
        entity.setSerialNumber(dto.getSerialNumber());
        entity.setPrice(dto.getPrice());
        entity.setManufacturer(dto.getManufacturer());
        entity.setSize(dto.getSize());
        return entity;
    }
}
