package pers.nefedov.demoshop.services;

import org.springframework.stereotype.Component;
import pers.nefedov.demoshop.utils.MonitorMapper;

import java.util.List;

@Component
public interface MonitorService {
    public MonitorMapper save(MonitorMapper mapper);
    public List<MonitorMapper> findAll();
    public MonitorMapper findById(long id);
    public int update(MonitorMapper mapper);

    public void deleteAll();
}
