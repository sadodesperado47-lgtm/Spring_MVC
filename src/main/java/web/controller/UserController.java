package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Вывод всей таблицы (Edit userId — чтобы знать, кого редактировать)
    @GetMapping
    public String getUsers(Model model, @RequestParam(value="editId", required=false) Long editId) {
        model.addAttribute("users", userService.getAllUsers());
        if (editId != null) {
            User userToEdit = userService.getUserById(editId);
            model.addAttribute("editUser", userToEdit);
            model.addAttribute("editId", editId);
        }
        return "users";
    }

    // Добавление пользователя
    @PostMapping
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    // Удаление пользователя
    @GetMapping("/delete/{id}")
    public String removeUser(@PathVariable Long id) {
        userService.removeUser(id);
        return "redirect:/users";
    }

    // Обновление пользователя (Update)
    @PostMapping("/edit")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }
}