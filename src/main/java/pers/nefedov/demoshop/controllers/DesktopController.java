package pers.nefedov.demoshop.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pers.nefedov.demoshop.dto.DesktopDto;
import pers.nefedov.demoshop.services.DesktopService;

import java.util.List;

@RestController
@RequestMapping("desktops")
public class DesktopController {
    @Autowired
    DesktopService desktopService;

    @GetMapping(value = "/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<DesktopDto>> getAll() {
        final List<DesktopDto> allDesktops = desktopService.findAll();
        return allDesktops != null && !allDesktops.isEmpty() ?
                new ResponseEntity<>(allDesktops, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DesktopDto> getById(@PathVariable long id) {
        final  DesktopDto desktopDto = desktopService.findById(id);
        return desktopDto != null ?
                new ResponseEntity<>(desktopDto, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addItem(@Valid @RequestBody DesktopDto desktopDto) {
        desktopService.save(desktopDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(value = "/update")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> update(@Valid @RequestBody DesktopDto desktopDto) {
        final int updated = desktopService.update(desktopDto);
        return updated == 1 ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
