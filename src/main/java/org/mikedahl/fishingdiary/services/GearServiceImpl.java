package org.mikedahl.fishingdiary.services;

import org.mikedahl.fishingdiary.repositories.GearRepository;
import org.springframework.stereotype.Service;
import org.mikedahl.fishingdiary.models.Gear;

import java.util.List;

@Service
public class GearServiceImpl implements GearService {

    private GearRepository GearRepository;

    public GearServiceImpl(GearRepository gearRepository) {
        super();
        this.GearRepository = gearRepository;
    }

    @Override
    public List<Gear> getAllGear() {
        return GearRepository.findAll();
    }



    @Override
    public Gear saveGear(Gear gear) {

        return GearRepository.save(gear);
    }

    @Override
    public Gear getGearById(Integer id) {
        return GearRepository.findById(id).get();
    }

    @Override
    public Gear updateGear(Gear gear) {
        return GearRepository.save(gear);
    }

    @Override
    public void deleteGearById(Integer id) {
        GearRepository.deleteById(id);
    }
}
