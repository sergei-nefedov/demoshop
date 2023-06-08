package pers.nefedov.demoshop.services;

import org.springframework.stereotype.Component;
import pers.nefedov.demoshop.utils.DesktopMapper;

import java.util.List;

@Component
public interface DesktopService1 {
    public void save(DesktopMapper mapper);
    public List<DesktopMapper> findAll();
    public DesktopMapper findById(long id);
    public int update(DesktopMapper mapper);
}
