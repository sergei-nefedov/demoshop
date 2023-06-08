package pers.nefedov.demoshop.services;

import org.springframework.stereotype.Component;
import pers.nefedov.demoshop.utils.NotebookMapper;


import java.util.List;

@Component
public interface NotebookService {
    public void save(NotebookMapper mapper);
    public List<NotebookMapper> findAll();
    public NotebookMapper findById(long id);
    public int update(NotebookMapper mapper);
}
