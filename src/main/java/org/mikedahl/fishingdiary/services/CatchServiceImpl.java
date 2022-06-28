package org.mikedahl.fishingdiary.services;

import org.mikedahl.fishingdiary.models.Catch;

import org.mikedahl.fishingdiary.models.User;
import org.mikedahl.fishingdiary.repositories.CatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatchServiceImpl implements CatchService {

    private CatchRepository catchRepository;

    public CatchServiceImpl(CatchRepository catchRepository) {
        super();
        this.catchRepository = catchRepository;
    }

    @Override
    public List<Catch> getAllbyUser(User user) {
        return catchRepository.findByUser(user);
    }

    @Override
    public List<Catch> getAllCatch() {
        return catchRepository.findAll();
    }

    @Override
    public Catch saveCatch(Catch c) {

        return catchRepository.save(c);
    }

    @Override
    public Catch getCatchById(Integer id) {
        return catchRepository.findById(id).get();
    }

    @Override
    public Catch updateCatch(Catch c) {
        return catchRepository.save(c);
    }

    @Override
    public void deleteCatchById(Integer id) {
        catchRepository.deleteById(id);
    }
}