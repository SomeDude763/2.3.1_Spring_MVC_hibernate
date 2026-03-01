package group.controller;

import group.model.User;
import group.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String allUser(Model model) {
        List<User> users = userService.allUsers();
        model.addAttribute("usersList", users);
        return "users";
    }

    @GetMapping(value = "/edit")
    public String editPage(@RequestParam(value = "id") int id,Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "editPage";
    }

    @PostMapping(value = "/edit")
    public String editUser(@ModelAttribute("users") User user) {
        userService.edit(user);
        return "redirect:/";
    }

    @GetMapping(value = "/add")
    public String addPage(Model model) {
        model.addAttribute("user",new User());
        return "editPage";
    }

    @PostMapping(value = "/add")
    public String addUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @PostMapping(value = "/delete")
    public String deleteUser(@RequestParam(value = "id") int id) {
        User user = userService.getById(id);
        userService.delete(user);
        return "redirect:/";
    }
}
