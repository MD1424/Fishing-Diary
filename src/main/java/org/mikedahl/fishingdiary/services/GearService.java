package org.mikedahl.fishingdiary.services;

import org.mikedahl.fishingdiary.models.Gear;

import java.util.List;

public interface GearService {

    List<Gear> getAllGear();

    Gear saveGear(Gear gear);

    Gear getGearById(Integer id);

    Gear updateGear(Gear gear);

    void deleteGearById(Integer id);

}
