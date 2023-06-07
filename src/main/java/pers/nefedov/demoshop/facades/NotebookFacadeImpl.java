package pers.nefedov.demoshop.facades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.nefedov.demoshop.dto.NotebookDto;
import pers.nefedov.demoshop.services.NotebookService;

import java.util.List;
@Service
public class NotebookFacadeImpl implements NotebookFacade {
    @Autowired
    NotebookService notebookService;
    @Override
    public void save(NotebookDto notebookDto) {
        notebookService.save(notebookDto);
    }

    @Override
    public List<NotebookDto> findAll() {
        return notebookService.findAll();
    }

    @Override
    public NotebookDto findById(long id) {
        return notebookService.findById(id);
    }

    @Override
    public int update(NotebookDto notebookDto) {
        return notebookService.update(notebookDto);
    }
}
