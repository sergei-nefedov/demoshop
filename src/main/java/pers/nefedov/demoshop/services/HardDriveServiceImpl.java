package pers.nefedov.demoshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.nefedov.demoshop.entities.HardDrive;
import pers.nefedov.demoshop.repositories.HardDriveRepository;
import pers.nefedov.demoshop.utils.HardDriveMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HardDriveServiceImpl implements HardDriveService {
    @Autowired
    HardDriveRepository hardDriveRepository;

    @Transactional
    public HardDriveMapper save(HardDriveMapper mapper) {
        hardDriveRepository.save(mapper.getEntity());
        hardDriveRepository.flush();
        return new HardDriveMapper(mapper.getEntity());
    }

    public List<HardDriveMapper> findAll() {
        return hardDriveRepository.findAll().stream().
                map(HardDriveMapper::new).collect(Collectors.toList());
    }

    public HardDriveMapper findById(long id) {
        HardDrive foundMonitor = hardDriveRepository.findById(id).orElse(null);
        return foundMonitor != null ?
                new HardDriveMapper(foundMonitor) :
                null;
    }

    @Transactional
    public int update(HardDriveMapper mapper) {
        HardDrive newHardDrive = mapper.getEntity();
        return hardDriveRepository.updateById(newHardDrive.getCapacity(), newHardDrive.getSerialNumber(),
                newHardDrive.getManufacturer(), newHardDrive.getPrice(),newHardDrive.getQuantity(), mapper.getDto().getId());
    }

    @Override
    public void deleteAll() {
        hardDriveRepository.deleteAll();
    }
}

