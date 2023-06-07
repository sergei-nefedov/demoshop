package pers.nefedov.demoshop.facades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.nefedov.demoshop.dto.DesktopDto;
import pers.nefedov.demoshop.services.DesktopService;

import java.util.List;
@Service
public class DesktopFacadeImpl implements DesktopFacade {
@Autowired
    DesktopService desktopService;
    @Override
    public void save(DesktopDto desktopDto) {
        desktopService.save(desktopDto);
    }

    @Override
    public List<DesktopDto> findAll() {
        return desktopService.findAll();
    }

    @Override
    public DesktopDto findById(long id) {
        return desktopService.findById(id);
    }

    @Override
    public int update(DesktopDto desktopDto) {
        return desktopService.update(desktopDto);
    }
}
