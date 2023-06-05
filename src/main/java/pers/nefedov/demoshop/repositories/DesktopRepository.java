package pers.nefedov.demoshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;
import pers.nefedov.demoshop.entities.Desktop;
import pers.nefedov.demoshop.entities.FormFactor;

public interface DesktopRepository extends JpaRepository<Desktop, Long> {
    @Override
    boolean existsById(Long id);

    @Transactional
    @Modifying
    @Query("""
            update Desktop d set d.formFactor = ?1, d.serialNumber = ?2, d.manufacturer = ?3, d.price = ?4, d.quantity = ?5
            where d.id = ?6""")
    int updateById(@NonNull FormFactor formFactor, @NonNull long serialNumber, @NonNull String manufacturer, @NonNull double price, @NonNull int quantity, Long id);

}