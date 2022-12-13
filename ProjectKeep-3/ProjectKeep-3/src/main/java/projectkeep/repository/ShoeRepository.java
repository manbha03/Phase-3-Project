package projectkeep.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import projectkeep.model.ShoeEntity;

import java.util.List;

public interface ShoeRepository extends CrudRepository<ShoeEntity, Integer> {
    public Long countById(Integer id);

    @Query("select shoe from ShoeEntity shoe where shoe.shoeCategory=?1")
    public List<ShoeEntity> searchByCategory(String shoeCategory);
}
