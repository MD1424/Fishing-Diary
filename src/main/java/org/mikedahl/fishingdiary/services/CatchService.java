package org.mikedahl.fishingdiary.services;

import org.mikedahl.fishingdiary.models.Catch;
import org.mikedahl.fishingdiary.models.User;

import java.util.List;

public interface CatchService {
    List<Catch> getAllbyUser(User user);
    List<Catch> getAllCatch();

    Catch saveCatch(Catch c);

    Catch getCatchById(Integer id);

    Catch updateCatch(Catch c);

    void deleteCatchById(Integer id);
}
