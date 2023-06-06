package pers.nefedov.demoshop.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pers.nefedov.demoshop.dto.HardDriveDto;
import pers.nefedov.demoshop.services.HardDriveService;

import java.util.List;

@RestController
@RequestMapping("harddrives")
public class HardDriveController {
    @Autowired
    HardDriveService hardDriveService;

    @GetMapping(value = "/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<HardDriveDto>> getAll() {
        final List<HardDriveDto> allHardDrives = hardDriveService.findAll();
        return allHardDrives != null && !allHardDrives.isEmpty() ?
                new ResponseEntity<>(allHardDrives, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HardDriveDto> getById(@PathVariable long id) {
        final HardDriveDto hardDriveDto = hardDriveService.findById(id);
        return hardDriveDto != null ?
                new ResponseEntity<>(hardDriveDto, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addItem(@Valid @RequestBody HardDriveDto hardDriveDto) {
        hardDriveService.save(hardDriveDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(value = "/update")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> update(@Valid @RequestBody HardDriveDto hardDriveDto) {
        final int updated = hardDriveService.update(hardDriveDto);
        return updated == 1 ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
