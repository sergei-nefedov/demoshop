package pers.nefedov.demoshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;
import pers.nefedov.demoshop.entities.HardDrive;


public interface HardDriveRepository extends JpaRepository<HardDrive, Long> {
    @Override
    boolean existsById(@NonNull Long id);

    @Transactional
    @Modifying
    @Query("""
            update HardDrive h set h.capacity = ?1, h.serialNumber = ?2, h.manufacturer = ?3, h.price = ?4, h.quantity = ?5
            where h.id = ?6""")
    int updateById(@NonNull int capacity, @NonNull long serialNumber, @NonNull String manufacturer, @NonNull double price, @NonNull int quantity, Long id);

}