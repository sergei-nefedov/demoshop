package pers.nefedov.demoshop.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pers.nefedov.demoshop.dto.MonitorDto;
import pers.nefedov.demoshop.facades.MonitorFacade;

import java.util.List;

@RestController
@RequestMapping("monitors")
public class MonitorController {
    @Autowired
    MonitorFacade monitorFacade;

    @GetMapping(value = "/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<MonitorDto>> getAll() {
        final List<MonitorDto> allMonitors = monitorFacade.findAll();
        return allMonitors != null && !allMonitors.isEmpty() ?
                new ResponseEntity<>(allMonitors, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MonitorDto> getById(@PathVariable long id) {
        final MonitorDto monitorDto = monitorFacade.findById(id);
        return monitorDto != null ?
                new ResponseEntity<>(monitorDto, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addItem(@Valid @RequestBody MonitorDto monitorDto) {
        return new ResponseEntity<>(monitorFacade.save(monitorDto), HttpStatus.CREATED);
    }

    @PostMapping(value = "/update")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> update(@Valid @RequestBody MonitorDto monitorDto) {
        final int updated = monitorFacade.update(monitorDto);
        return updated == 1 ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping(value =  "/delete/all")
    public ResponseEntity<?> deleteAll() {
        monitorFacade.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
