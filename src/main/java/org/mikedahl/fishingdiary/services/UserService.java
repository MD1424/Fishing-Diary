package org.mikedahl.fishingdiary.services;

import org.mikedahl.fishingdiary.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.mikedahl.fishingdiary.security.UserRegistrationDto;

public interface UserService extends UserDetailsService {
    User findByEmail(String email);
    User save(UserRegistrationDto registration);
}