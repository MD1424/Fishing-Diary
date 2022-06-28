package org.mikedahl.fishingdiary.repositories;
import org.mikedahl.fishingdiary.models.BOW;

import org.mikedahl.fishingdiary.models.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BOWRepository extends JpaRepository<BOW, Integer> {
    public BOW findByBOW(String BOW);
}
