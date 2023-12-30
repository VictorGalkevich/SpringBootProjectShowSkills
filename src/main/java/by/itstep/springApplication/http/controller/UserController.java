package by.itstep.springApplication.http.controller;

import by.itstep.springApplication.dto.UserCreateEditDto;
import by.itstep.springApplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping
    public String findAll(Model model) {
        /*model.addAttribute("users", userService.finAll());*/
        return "user/users";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {
        /*model.addAttribute("users", userService.findById(id));*/
        return "user/user";
    }

    @PostMapping
    public String create(UserCreateEditDto user) {
        /*userService.create(user);*/
        return "redirect:/users/25";
    }

    //@PutMapping("/{id}")
    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") Long id, UserCreateEditDto user) {
        /*userService.update(id, user);*/
        return "redirect:/users/{id}";
    }

    //@DeleteMapping("/{id}")
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        /*userService.delete(id);*/
        return "redirect:/users";
    }
}
