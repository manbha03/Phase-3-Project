package projectkeep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import projectkeep.model.ShoeEntity;
import projectkeep.service.PurchaseService;

import java.util.List;

@Controller
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    //Controller for Filter Category
    @RequestMapping("/report/search")
    public String viewResult(Model model, @Param("keyword") String keyword) {

        List<ShoeEntity> listResults = purchaseService.listAll(keyword);
        model.addAttribute("listShoes", listResults);
        model.addAttribute("keyword", keyword);
        return "search_form";
    }

}
