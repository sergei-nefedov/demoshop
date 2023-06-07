package pers.nefedov.demoshop.facades;

import pers.nefedov.demoshop.dto.NotebookDto;

import java.util.List;

public interface NotebookFacade {
    public void save(NotebookDto notebookDto);
    public List<NotebookDto> findAll();
    public NotebookDto findById(long id);
    public int update(NotebookDto notebookDto);
}
