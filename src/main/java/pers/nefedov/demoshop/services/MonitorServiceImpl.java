package pers.nefedov.demoshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.nefedov.demoshop.dto.MonitorDto;
import pers.nefedov.demoshop.entities.Monitor;
import pers.nefedov.demoshop.repositories.MonitorRepository;
import pers.nefedov.demoshop.utils.MonitorMappingUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MonitorServiceImpl implements MonitorService {
    @Autowired
    MonitorRepository monitorRepository;
    @Autowired
    MonitorMappingUtils monitorMappingUtils;

    @Transactional
    public void save(MonitorDto monitorDto) {
        Monitor monitor = monitorMappingUtils.mapToMonitorEntity(monitorDto);
        monitorRepository.save(monitor);
    }

    public List<MonitorDto> findAll() {
        return monitorRepository.findAll().stream().
                map(monitorMappingUtils::mapToMonitorDto).collect(Collectors.toList());
    }

    public MonitorDto findById(long id) {
        Monitor foundMonitor = monitorRepository.findById(id).orElse(null);
        return foundMonitor != null ?
                monitorMappingUtils.mapToMonitorDto(foundMonitor) :
                null;
    }

    @Transactional
    public int update(MonitorDto monitorDto) {
        Monitor newMonitor = monitorMappingUtils.mapToMonitorEntity(monitorDto);
        return monitorRepository.updateById(newMonitor.getDiagonalSize(), newMonitor.getSerialNumber(),
                newMonitor.getManufacturer(), newMonitor.getPrice(),newMonitor.getQuantity(), monitorDto.getId());
    }
}
