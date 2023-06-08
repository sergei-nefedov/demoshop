package pers.nefedov.demoshop.facades;

import pers.nefedov.demoshop.dto.MonitorDto;

import java.util.List;

public interface MonitorFacade {
    public MonitorDto save(MonitorDto monitorDto);
    public List<MonitorDto> findAll();
    public MonitorDto findById(long id);
    public int update(MonitorDto monitorDto);

    public void deleteAll();
}
