package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;
import java.util.List;


@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUser(@RequestParam(value = "count", required = false) Integer count, ModelMap modelMap) {
        int displayCount = (count == null) ? 5 : count;
        List<User> car = userService.getUsers(displayCount);
        modelMap.addAttribute("cars", car);
        return "user";
    }
}
