package pers.nefedov.demoshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.nefedov.demoshop.entities.Desktop;

public interface DesktopRepository extends JpaRepository<Desktop, Long> {
//    @Transactional
//    @Modifying
//    @Query("update Desktop d set d.id = ?1, d.formFactor = ?2 where d.formFactor = ?3 and d.id = ?4")
//    void updateIdAndFormFactorByFormFactorAndId(Long id, FormFactor formFactor, FormFactor formFactor1, Long id1);

    //void update(Desktop desktop);
}