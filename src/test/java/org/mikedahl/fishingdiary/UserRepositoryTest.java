package org.mikedahl.fishingdiary;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.mikedahl.fishingdiary.models.User;
import org.mikedahl.fishingdiary.repositories.UserRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByEmail() {
        User user = userRepository.findByEmail("test@test.com");
        assertThat(user).isNotNull();
        System.out.println("--findByEmail working--");
        System.out.println(user.getFirstName());
    }
}
