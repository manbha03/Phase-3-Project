package projectkeep.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import projectkeep.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public Long countById(Integer id);

    @Query("select user from User user where user.email=?1")
    public User findLogin(String email);
}
