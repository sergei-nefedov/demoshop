package pers.nefedov.demoshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.nefedov.demoshop.entities.Notebook;
import pers.nefedov.demoshop.repositories.NotebookRepository;
import pers.nefedov.demoshop.utils.NotebookMapper;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotebookServiceImpl implements NotebookService {
    @Autowired
    NotebookRepository notebookRepository;

    @Transactional
    public void save(NotebookMapper mapper) {
        notebookRepository.save(mapper.getEntity());
    }

    public List<NotebookMapper> findAll() {
        return notebookRepository.findAll().stream().
                map(NotebookMapper::new).collect(Collectors.toList());
    }

    public NotebookMapper findById(long id) {
        Notebook foundNotebook = notebookRepository.findById(id).orElse(null);
        return foundNotebook != null ?
                new NotebookMapper(foundNotebook) :
                null;
    }

    @Transactional
    public int update(NotebookMapper mapper) {
        Notebook newNotebook = mapper.getEntity();
        return notebookRepository.updateById(newNotebook.getSize(), newNotebook.getSerialNumber(),
                newNotebook.getManufacturer(), newNotebook.getPrice(),newNotebook.getQuantity(), mapper.getDto().getId());
    }
}
