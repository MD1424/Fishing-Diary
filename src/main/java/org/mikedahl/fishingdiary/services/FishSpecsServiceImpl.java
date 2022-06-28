package org.mikedahl.fishingdiary.services;

import org.mikedahl.fishingdiary.models.FishSpecs;
import org.mikedahl.fishingdiary.models.FishSpecs;
import org.mikedahl.fishingdiary.repositories.FishSpecsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FishSpecsServiceImpl implements FishSpecsService {

    private FishSpecsRepository fishSpecsRepository;

    public FishSpecsServiceImpl(FishSpecsRepository fishSpecsRepository) {
        super();
        this.fishSpecsRepository = fishSpecsRepository;
    }

    @Override
    public List<FishSpecs> getAllFishSpecs() {
        return fishSpecsRepository.findAll();
    }

    @Override
    public FishSpecs saveFishSpecs(FishSpecs fishspecs) {

        return fishSpecsRepository.save(fishspecs);
    }

    @Override
    public FishSpecs getFishSpecsById(Integer id) {
        return fishSpecsRepository.findById(id).get();
    }

    @Override
    public FishSpecs updateFishSpecs(FishSpecs fishSpecs) {
        return fishSpecsRepository.save(fishSpecs);
    }

    @Override
    public void deleteFishSpecsById(Integer id) {
        fishSpecsRepository.deleteById(id);
    }
}