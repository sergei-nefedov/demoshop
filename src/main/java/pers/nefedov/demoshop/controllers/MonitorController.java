package pers.nefedov.demoshop.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pers.nefedov.demoshop.dto.MonitorDto;
import pers.nefedov.demoshop.services.MonitorService;

import java.util.List;

@RestController
@RequestMapping("monitors")
public class MonitorController {
    @Autowired
    MonitorService monitorService;

    @GetMapping(value = "/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<MonitorDto>> getAll() {
        final List<MonitorDto> allMonitors = monitorService.findAll();
        return allMonitors != null && !allMonitors.isEmpty() ?
                new ResponseEntity<>(allMonitors, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MonitorDto> getById(@PathVariable long id) {
        final MonitorDto monitorDto = monitorService.findById(id);
        return monitorDto != null ?
                new ResponseEntity<>(monitorDto, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addItem(@Valid @RequestBody MonitorDto monitorDto) {
        monitorService.save(monitorDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(value = "/update")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> update(@Valid @RequestBody MonitorDto monitorDto) {
        final int updated = monitorService.update(monitorDto);
        return updated == 1 ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
