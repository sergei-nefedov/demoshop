package pers.nefedov.demoshop.facades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.nefedov.demoshop.dto.MonitorDto;
import pers.nefedov.demoshop.services.MonitorService;

import java.util.List;
@Service
public class MonitorFacadeImpl implements MonitorFacade {
    @Autowired
    MonitorService monitorService;
    @Override
    public void save(MonitorDto monitorDto) {
        monitorService.save(monitorDto);
    }

    @Override
    public List<MonitorDto> findAll() {
        return monitorService.findAll();
    }

    @Override
    public MonitorDto findById(long id) {
        return monitorService.findById(id);
    }

    @Override
    public int update(MonitorDto monitorDto) {
        return monitorService.update(monitorDto);
    }
}
