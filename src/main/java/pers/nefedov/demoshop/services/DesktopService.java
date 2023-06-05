package pers.nefedov.demoshop.services;

import org.springframework.stereotype.Component;
import pers.nefedov.demoshop.dto.DesktopDto;

import java.util.List;

@Component
public interface DesktopService {
    public void save(DesktopDto desktopDto);
    public List<DesktopDto> findAll();
    public DesktopDto findById(long id);
    public int update(DesktopDto desktopDto);
}
