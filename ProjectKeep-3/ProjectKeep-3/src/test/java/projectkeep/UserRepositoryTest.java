package projectkeep;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import projectkeep.model.User;
import projectkeep.repository.UserRepository;
import java.util.Optional;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
    @Autowired private UserRepository repo;
    @Test
    public  void testAddUser(){

        User user = new User();

        user.setEmail("daka@gmail.com");
        user.setPassword("Winnerson");
        user.setFirstName("Daka");
        user.setLastName("Ryngkhlem");

        User savedUser = repo.save(user);
        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public  void testGetUsers(){
        Iterable<User> user = repo.findAll();
        Assertions.assertThat(user).hasSizeGreaterThan(0);

        for(User users : user){
            System.out.println(users);
        }
    }
    @Test
    public void testUpdate(){

        Integer userId=3;
        Optional<User> optionalUser = repo.findById(userId);
        User  user = optionalUser.get();
        user.setPassword("hello2022");
        repo.save(user);

        User updateUser = repo.findById(userId).get();
        Assertions.assertThat(updateUser.getPassword()).isEqualTo("hello2022");
    }
    @Test
    public  void testGet(){
        Integer userId=1;
        Optional<User> optionalUser = repo.findById(userId);
        Assertions.assertThat(optionalUser).isPresent();
        System.out.println(optionalUser.get());
    }
    @Test
    public  void testDeleteById(){
        Integer userId=1;
        repo.deleteById(userId);
        Optional<User> optionalUser = repo.findById(userId);
        Assertions.assertThat(optionalUser).isNotPresent();
    }
}
