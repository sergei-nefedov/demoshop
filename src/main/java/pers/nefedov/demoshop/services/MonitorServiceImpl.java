package pers.nefedov.demoshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.nefedov.demoshop.entities.Monitor;
import pers.nefedov.demoshop.repositories.MonitorRepository;
import pers.nefedov.demoshop.utils.MonitorMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MonitorServiceImpl implements MonitorService {
    @Autowired
    MonitorRepository monitorRepository;

    @Transactional
    public void save(MonitorMapper mapper) {
        monitorRepository.save(mapper.getEntity());
    }

    public List<MonitorMapper> findAll() {
        return monitorRepository.findAll().stream().
                map(MonitorMapper::new).collect(Collectors.toList());
    }

    public MonitorMapper findById(long id) {
        Monitor foundMonitor = monitorRepository.findById(id).orElse(null);
        return foundMonitor != null ?
                new MonitorMapper(foundMonitor) :
                null;
    }

    @Transactional
    public int update(MonitorMapper mapper) {
        Monitor newMonitor = mapper.getEntity();
        return monitorRepository.updateById(newMonitor.getDiagonalSize(), newMonitor.getSerialNumber(),
                newMonitor.getManufacturer(), newMonitor.getPrice(),newMonitor.getQuantity(), mapper.getDto().getId());
    }
}
