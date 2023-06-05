package pers.nefedov.demoshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;
import pers.nefedov.demoshop.entities.Notebook;


public interface NotebookRepository extends JpaRepository<Notebook, Long> {
    @Override
    boolean existsById(@NonNull Long id);

    @Transactional
    @Modifying
    @Query("""
            update Notebook n set n.size = ?1, n.serialNumber = ?2, n.manufacturer = ?3, n.price = ?4, n.quantity = ?5
            where n.id = ?6""")
    int updateById(@NonNull int size, @NonNull long serialNumber, @NonNull String manufacturer, @NonNull double price, @NonNull int quantity, Long id);

}