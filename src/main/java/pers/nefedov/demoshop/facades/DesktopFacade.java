package pers.nefedov.demoshop.facades;

import pers.nefedov.demoshop.dto.DesktopDto;

import java.util.List;

public interface DesktopFacade {
    public void save(DesktopDto desktopDto);
    public List<DesktopDto> findAll();
    public DesktopDto findById(long id);
    public int update(DesktopDto desktopDto);
}
