package pers.nefedov.demoshop.services;

import org.springframework.stereotype.Component;
import pers.nefedov.demoshop.utils.HardDriveMapper;

import java.util.List;

@Component
public interface HardDriveService {
    public void save(HardDriveMapper mapper);
    public List<HardDriveMapper> findAll();
    public HardDriveMapper findById(long id);
    public int update(HardDriveMapper mapper);
}
