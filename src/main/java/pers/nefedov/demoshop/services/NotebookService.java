package pers.nefedov.demoshop.services;

import org.springframework.stereotype.Component;
import pers.nefedov.demoshop.dto.NotebookDto;

import java.util.List;

@Component
public interface NotebookService {
    public void save(NotebookDto notebookDto);
    public List<NotebookDto> findAll();
    public NotebookDto findById(long id);
    public int update(NotebookDto desktopDto);
}
