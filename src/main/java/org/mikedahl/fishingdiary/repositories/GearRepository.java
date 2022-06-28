package org.mikedahl.fishingdiary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.mikedahl.fishingdiary.models.Gear;


import java.util.List;

public interface GearRepository extends JpaRepository<Gear, Integer> {
    List<Gear> findAll();

    void deleteById(Integer id);
    void save(Integer id);
}
