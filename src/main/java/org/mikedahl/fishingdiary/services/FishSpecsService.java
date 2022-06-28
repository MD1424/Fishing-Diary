package org.mikedahl.fishingdiary.services;

import org.mikedahl.fishingdiary.models.FishSpecs;

import java.util.List;

public interface FishSpecsService {
    List<FishSpecs> getAllFishSpecs();

    FishSpecs saveFishSpecs(FishSpecs fishSpecs);

    FishSpecs getFishSpecsById(Integer id);

    FishSpecs updateFishSpecs(FishSpecs fishSpecs);

    void deleteFishSpecsById(Integer id);
}
