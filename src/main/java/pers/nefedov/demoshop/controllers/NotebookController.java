package pers.nefedov.demoshop.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pers.nefedov.demoshop.dto.NotebookDto;
import pers.nefedov.demoshop.facades.NotebookFacade;

import java.util.List;

@RestController
@RequestMapping("notebooks")
public class NotebookController {
    @Autowired
    NotebookFacade notebookFacade;

    @GetMapping(value = "/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<NotebookDto>> getAll() {
        final List<NotebookDto> allNotebooks = notebookFacade.findAll();
        return allNotebooks != null && !allNotebooks.isEmpty() ?
                new ResponseEntity<>(allNotebooks, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotebookDto> getById(@PathVariable long id) {
        final NotebookDto notebookDto = notebookFacade.findById(id);
        return notebookDto != null ?
                new ResponseEntity<>(notebookDto, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addItem(@Valid @RequestBody NotebookDto notebookDto) {
        notebookFacade.save(notebookDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(value = "/update")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> update(@Valid @RequestBody NotebookDto notebookDto) {
        final int updated = notebookFacade.update(notebookDto);
        return updated == 1 ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
