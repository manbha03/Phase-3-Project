package projectkeep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import projectkeep.model.ShoeEntity;

import java.util.List;

@EnableJpaRepositories
public interface PurchaseRepository extends JpaRepository<ShoeEntity, Integer> {

    @Query("SELECT s FROM ShoeEntity s WHERE s.shoeCategory LIKE %?1%")
    public List<ShoeEntity> search(String keyword);
}
