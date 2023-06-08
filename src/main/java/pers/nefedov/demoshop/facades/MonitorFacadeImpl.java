package pers.nefedov.demoshop.facades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.nefedov.demoshop.dto.MonitorDto;
import pers.nefedov.demoshop.services.MonitorService;
import pers.nefedov.demoshop.utils.MonitorMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MonitorFacadeImpl implements MonitorFacade {
    @Autowired
    MonitorService monitorService;
    @Override
    public void save(MonitorDto monitorDto) {
        monitorService.save(new MonitorMapper(monitorDto));
    }

    @Override
    public List<MonitorDto> findAll() {
        return monitorService.findAll().stream().map(MonitorMapper::getDto).collect(Collectors.toList());
    }

    @Override
    public MonitorDto findById(long id) {
        return monitorService.findById(id).getDto();
    }

    @Override
    public int update(MonitorDto monitorDto) {
        return monitorService.update(new MonitorMapper(monitorDto));
    }
}
