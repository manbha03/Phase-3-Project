package projectkeep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectkeep.exceptionHandler.UserNotFoundException;
import projectkeep.model.ShoeEntity;
import projectkeep.repository.ShoeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShoeService {
    @Autowired
    ShoeRepository shoeRepository;

    public List<ShoeEntity> getShoesDetails() {
        List<ShoeEntity> getShoes = new ArrayList<>();
        for (ShoeEntity shoeEntity : shoeRepository.findAll()) {
            getShoes.add(shoeEntity);
        }
        return getShoes;
    }

    public void save(ShoeEntity shoeEntity) {
        shoeRepository.save(shoeEntity);
    }

    public ShoeEntity get(Integer id) throws UserNotFoundException {
        Optional<ShoeEntity> result = shoeRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new UserNotFoundException("Could not find Product with ID " + id);
    }

    public void delete(Integer id) throws UserNotFoundException {
        Long count = shoeRepository.countById(id);
        if (count == null || count == 0) {
            throw new UserNotFoundException("Could not find users with ID " + id);
        }
        shoeRepository.deleteById(id);
    }

    public List<ShoeEntity> searchResult(String shoeCategory) {

        if (shoeCategory != null) {
            return shoeRepository.searchByCategory(shoeCategory);
        }
        return (List<ShoeEntity>) shoeRepository.findAll();
    }

}

