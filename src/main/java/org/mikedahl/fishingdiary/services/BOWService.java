package org.mikedahl.fishingdiary.services;

import org.mikedahl.fishingdiary.models.BOW;

import java.util.List;

public interface BOWService {
    List<BOW> getAllBOW();

    BOW saveBOW(BOW bow);

    BOW getBOWById(Integer id);

    BOW updateBOW(BOW bow);

    void deleteBOWById(Integer id);
}
