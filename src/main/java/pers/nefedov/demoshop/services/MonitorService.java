package pers.nefedov.demoshop.services;

import org.springframework.stereotype.Component;
import pers.nefedov.demoshop.dto.MonitorDto;

import java.util.List;

@Component
public interface MonitorService {
    public void save(MonitorDto monitorDto);
    public List<MonitorDto> findAll();
    public MonitorDto findById(long id);
    public int update(MonitorDto monitorDto);
}
