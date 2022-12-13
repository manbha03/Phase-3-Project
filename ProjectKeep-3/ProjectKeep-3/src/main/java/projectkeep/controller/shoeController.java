package projectkeep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import projectkeep.exceptionHandler.UserNotFoundException;
import projectkeep.model.ShoeEntity;
import projectkeep.repository.ShoeRepository;
import projectkeep.service.ShoeService;

import java.util.List;

@Controller
public class shoeController {
    @Autowired
    ShoeService shoeService;
    @Autowired
    ShoeRepository shoeRepository;

    @GetMapping("/report")
    public String getReport(Model model) {
        List<ShoeEntity> listShoes = shoeService.getShoesDetails();
        model.addAttribute("pageTitle", "Product Report");
        model.addAttribute("listShoes", listShoes);
        return "report";
    }

    @GetMapping("/shoeDetails")
    public String getShoeDetails(Model model) {
        List<ShoeEntity> listShoes = shoeService.getShoesDetails();
        model.addAttribute("listShoes", listShoes);
        return "product";
    }

    @GetMapping("/shoeDetails/new")
    public String showNewForm(Model model) {
        model.addAttribute("shoe", new ShoeEntity());
        model.addAttribute("pageTitle", "Add New Product");
        return "add_shoes";
    }

    @PostMapping("/shoeDetails/save")
    public String saveUser(ShoeEntity shoeEntity, RedirectAttributes redirectAttributes) {
        shoeService.save(shoeEntity);
        redirectAttributes.addFlashAttribute("message", "Product Saved Successfully");
        return "redirect:/shoeDetails";
    }

    @GetMapping("/shoeDetails/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            ShoeEntity shoeEntity = shoeService.get(id);
            model.addAttribute("shoe", shoeEntity);
            model.addAttribute("pageTitle", "Edit User(ID: " + id + ")");
            return "add_shoes";
        } catch (UserNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", "Could not find user with ID " + id);
            return "redirect:/shoeDetails";
        }
    }

    @GetMapping("/shoeDetails/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        try {
            shoeService.delete(id);
            redirectAttributes.addFlashAttribute("message", "Product with ID " + id + " has been deleted");
        } catch (UserNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", "Could not find Product with ID " + id);
        }
        return "redirect:/shoeDetails";
    }
    //End Crud Repository for User Management

}
