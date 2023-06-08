package pers.nefedov.demoshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.nefedov.demoshop.entities.Desktop;
import pers.nefedov.demoshop.repositories.DesktopRepository;
import pers.nefedov.demoshop.utils.DesktopMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DesktopServiceImpl implements DesktopService {
    @Autowired
    DesktopRepository desktopRepository;

    @Transactional
    public void save(DesktopMapper mapper) {
        desktopRepository.save(mapper.getEntity());
    }

    public List<DesktopMapper> findAll() {
//        return desktopRepository.findAll().stream().
//                map(desktopMappingUtils::mapToDesktopDto).collect(Collectors.toList());
        return desktopRepository.findAll().stream().
                map(DesktopMapper::new).collect(Collectors.toList());
    }

    public DesktopMapper findById(long id) {
        Desktop foundDesktop = desktopRepository.findById(id).orElse(null);
        return foundDesktop != null ?
                new DesktopMapper(foundDesktop) :
                null;
    }

    @Transactional
    public int update(DesktopMapper mapper) {
        Desktop newDesktop = mapper.getEntity();
        return desktopRepository.updateById(newDesktop.getFormFactor(), newDesktop.getSerialNumber(),
                newDesktop.getManufacturer(), newDesktop.getPrice(),newDesktop.getQuantity(), mapper.getDto().getId());
    }
}