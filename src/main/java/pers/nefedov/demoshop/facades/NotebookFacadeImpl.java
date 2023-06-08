package pers.nefedov.demoshop.facades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.nefedov.demoshop.dto.NotebookDto;
import pers.nefedov.demoshop.services.NotebookService;
import pers.nefedov.demoshop.utils.NotebookMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotebookFacadeImpl implements NotebookFacade {
    @Autowired
    NotebookService notebookService;
    @Override
    public NotebookDto save(NotebookDto notebookDto) {
        notebookService.save(new NotebookMapper(notebookDto));
        return notebookService.save(new NotebookMapper(notebookDto)).getDto();
    }

    @Override
    public List<NotebookDto> findAll() {
        return notebookService.findAll().stream().map(NotebookMapper::getDto).collect(Collectors.toList());
    }

    @Override
    public NotebookDto findById(long id) {
        return notebookService.findById(id).getDto();
    }

    @Override
    public int update(NotebookDto notebookDto) {
        return notebookService.update(new NotebookMapper(notebookDto));
    }

    @Override
    public void deleteAll() {
        notebookService.deleteAll();
    }
}
