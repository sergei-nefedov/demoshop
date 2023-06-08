package pers.nefedov.demoshop.services;

import org.springframework.stereotype.Component;
import pers.nefedov.demoshop.utils.NotebookMapper;


import java.util.List;

@Component
public interface NotebookService {
    public NotebookMapper save(NotebookMapper mapper);
    public List<NotebookMapper> findAll();
    public NotebookMapper findById(long id);
    public int update(NotebookMapper mapper);

    public void deleteAll();
}
