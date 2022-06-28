package org.mikedahl.fishingdiary.services;

import org.mikedahl.fishingdiary.models.BOW;
import org.mikedahl.fishingdiary.models.Weather;
import org.mikedahl.fishingdiary.repositories.BOWRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BOWServiceImpl implements BOWService {

    private BOWRepository bowRepository;

    public BOWServiceImpl(BOWRepository bowRepository) {
        super();
        this.bowRepository = bowRepository;
    }

    @Override
    public List<BOW> getAllBOW() {
        return bowRepository.findAll();
    }

    @Override
    public BOW saveBOW(BOW bow) {
        BOW existingBOW = bowRepository.findByBOW(bow.getBOW());
        if (existingBOW == null){
            return bowRepository.save(bow);
        }

        return existingBOW;


    }

    @Override
    public BOW getBOWById(Integer id) {
        return bowRepository.findById(id).get();
    }

    @Override
    public BOW updateBOW(BOW bow) {
        return bowRepository.save(bow);
    }

    @Override
    public void deleteBOWById(Integer id) {
        bowRepository.deleteById(id);
    }
}
