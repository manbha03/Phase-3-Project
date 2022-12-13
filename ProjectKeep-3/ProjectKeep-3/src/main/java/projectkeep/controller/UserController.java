package projectkeep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import projectkeep.exceptionHandler.UserNotFoundException;
import projectkeep.model.User;
import projectkeep.repository.UserRepository;
import projectkeep.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    //Start Crud Repository for Admin Management
    @GetMapping("/users")
    public String showUserList(Model model) {
        List<User> listUsers = userService.getList();
        model.addAttribute("listUsers", listUsers);
        return "users";
    }

    @GetMapping("/users/new")
    public String showNewForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("pageTitle", "Add New User");
        return "user_form";
    }

    @PostMapping("/users/save")
    public String saveUser(User user, RedirectAttributes redirectAttributes) {
        userService.save(user);
        redirectAttributes.addFlashAttribute("message", "User Added Successfully");
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            User user = userService.get(id);
            model.addAttribute("user", user);
            model.addAttribute("pageTitle", "Edit User(ID: " + id + ")");
            return "user_form";
        } catch (UserNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", "Could not find user with ID " + id);
            return "redirect:/users";
        }
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        try {
            userService.delete(id);
            redirectAttributes.addFlashAttribute("message", "User with ID " + id + " has been deleted");
        } catch (UserNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", "Could not find user with ID " + id);
        }
        return "redirect:/users";
    }
    //End Crud Repository for User Management

    //Controller for Lofin
    @GetMapping("/login")
    public String loginPage() {
        return "login_form";
    }

    @ResponseBody
    @RequestMapping("/admin")
    public ModelAndView userLogin(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView();
        String email = request.getParameter("email");
        if (userRepository.findLogin(email) != null) {
            modelAndView.setViewName("users");
        } else modelAndView.setViewName("login_form");
        return modelAndView;

    }

}
