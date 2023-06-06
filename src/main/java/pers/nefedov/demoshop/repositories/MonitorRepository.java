package pers.nefedov.demoshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;
import pers.nefedov.demoshop.entities.Monitor;


public interface MonitorRepository extends JpaRepository<Monitor, Long> {
    @Override
    boolean existsById(@NonNull Long id);

    @Transactional
    @Modifying
    @Query("""
            update Monitor m set m.diagonalSize = ?1, m.serialNumber = ?2, m.manufacturer = ?3, m.price = ?4, m.quantity = ?5
            where m.id = ?6""")
    int updateById(@NonNull int diagonalSize, @NonNull long serialNumber, @NonNull String manufacturer, @NonNull double price, @NonNull int quantity, Long id);

}