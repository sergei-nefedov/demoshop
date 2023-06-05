package pers.nefedov.demoshop.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pers.nefedov.demoshop.dto.DesktopDto;
import pers.nefedov.demoshop.services.DesktopService;

import java.util.List;

@RestController
public class DesktopController {
    @Autowired
    //DesktopRepository desktopRepository;
    DesktopService desktopService;

    @GetMapping(value = "desktops/all")
    @ResponseStatus(HttpStatus.OK)
    List<DesktopDto> getAll() {
        return desktopService.findAll();
    }

    @GetMapping("desktops/{id}")
    DesktopDto getById(@PathVariable long id) {
        return desktopService.findById(id);
    }

    @PostMapping(value = "desktops/add")
    @ResponseStatus(HttpStatus.CREATED)
    void addItem(@Valid @RequestBody DesktopDto desktopDto) {
        desktopService.save(desktopDto);
    }

    @PostMapping(value = "desktops/update")
    @ResponseStatus(HttpStatus.OK)
    void update(@Valid @RequestBody DesktopDto desktopDto) {
        desktopService.update(desktopDto);
    }

}
