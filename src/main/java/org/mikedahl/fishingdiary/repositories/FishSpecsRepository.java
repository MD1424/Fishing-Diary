package org.mikedahl.fishingdiary.repositories;

import org.mikedahl.fishingdiary.models.FishSpecs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FishSpecsRepository extends JpaRepository<FishSpecs, Integer> {
}
