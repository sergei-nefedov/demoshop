package pers.nefedov.demoshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.nefedov.demoshop.dto.DesktopDto;
import pers.nefedov.demoshop.entities.Desktop;
import pers.nefedov.demoshop.repositories.DesktopRepository;
import pers.nefedov.demoshop.utils.DesktopMappingUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DesktopServiceImpl implements DesktopService {
    @Autowired
    DesktopRepository desktopRepository;
    @Autowired
    DesktopMappingUtils desktopMappingUtils;

    @Transactional
    public void save(DesktopDto desktopDto) {
        Desktop desktop = desktopMappingUtils.mapToDesktopEntity(desktopDto);
        desktopRepository.save(desktop);
    }

    public List<DesktopDto> findAll() {
        return desktopRepository.findAll().stream().
                map(desktopMappingUtils::mapToDesktopDto).collect(Collectors.toList());
    }

    public DesktopDto findById(long id) {
        Desktop foundDesktop = desktopRepository.findById(id).orElse(null);
        return foundDesktop != null ?
                desktopMappingUtils.mapToDesktopDto(foundDesktop) :
                null;
    }

    @Transactional
    public int update(DesktopDto desktopDto) {
        Desktop newDesktop = desktopMappingUtils.mapToDesktopEntity(desktopDto);
        return desktopRepository.updateById(newDesktop.getFormFactor(), newDesktop.getSerialNumber(),
                newDesktop.getManufacturer(), newDesktop.getPrice(),newDesktop.getQuantity(), desktopDto.getId());
    }
}