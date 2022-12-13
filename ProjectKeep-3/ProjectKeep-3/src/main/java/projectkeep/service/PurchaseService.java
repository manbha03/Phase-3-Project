package projectkeep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectkeep.model.ShoeEntity;
import projectkeep.repository.PurchaseRepository;

import java.util.List;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<ShoeEntity> listAll(String keyword) {
        if (keyword != null) {
            return purchaseRepository.search(keyword);
        }
        return purchaseRepository.findAll();
    }
}
