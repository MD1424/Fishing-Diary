package org.mikedahl.fishingdiary.repositories;

import org.mikedahl.fishingdiary.models.Catch;

import org.mikedahl.fishingdiary.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CatchRepository extends JpaRepository<Catch, Integer> {
    public List<Catch> findByUser(User user);
}
