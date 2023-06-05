package pers.nefedov.demoshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.nefedov.demoshop.dto.NotebookDto;
import pers.nefedov.demoshop.entities.Notebook;
import pers.nefedov.demoshop.repositories.NotebookRepository;
import pers.nefedov.demoshop.utils.NotebookMappingUtils;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotebookServiceImpl implements NotebookService {
    @Autowired
    NotebookRepository notebookRepository;
    @Autowired
    NotebookMappingUtils notebookMappingUtils;

    @Transactional
    public void save(NotebookDto notebookDto) {
        Notebook notebook = notebookMappingUtils.mapToNotebookEntity(notebookDto);
        notebookRepository.save(notebook);
    }

    public List<NotebookDto> findAll() {
        return notebookRepository.findAll().stream().
                map(notebookMappingUtils::mapToNotebookDto).collect(Collectors.toList());
    }

    public NotebookDto findById(long id) {
        Notebook foundNotebook = notebookRepository.findById(id).orElse(null);
        return foundNotebook != null ?
                notebookMappingUtils.mapToNotebookDto(foundNotebook) :
                null;
    }

    @Transactional
    public int update(NotebookDto notebookDto) {
        Notebook newNotebook = notebookMappingUtils.mapToNotebookEntity(notebookDto);
        return notebookRepository.updateById(newNotebook.getSize(), newNotebook.getSerialNumber(),
                newNotebook.getManufacturer(), newNotebook.getPrice(),newNotebook.getQuantity(), notebookDto.getId());
    }
}
