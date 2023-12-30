package by.itstep.springApplication.http.controller;

import by.itstep.springApplication.database.entity.Role;
import by.itstep.springApplication.dto.UserReadDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("api/v1")
@SessionAttributes({"user"})
public class GreetingController {

    @ModelAttribute
    public List<Role> roles() {
        return Arrays.asList(Role.values());
    }

    @GetMapping("/hello")
    public String hello(Model model, HttpServletRequest request, UserReadDto userReadDto) {
        /*model.addAttribute("user", new UserReadDto(1L, "kirchenok"));*/
        return "greeting/hello";
    }

    @GetMapping("/hello/{id}")
    public ModelAndView hello2(ModelAndView modelAndView, HttpServletRequest request,
                              @RequestParam(name = "age") Integer age,
                              @RequestHeader(name = "accept") String header,
                              @CookieValue(name = "JSESSIONID") String jsessionid,
                              @PathVariable(name = "id") Integer id) {
        String ageReq = request.getParameter("age");
        String headerRe1 = request.getHeader("age");
        Cookie[] cookies = request.getCookies();
        modelAndView.setViewName("greeting/hello");
        return modelAndView;
    }

    @GetMapping("/bye")
    public String bye(@SessionAttribute("user") UserReadDto user) {
        return "greeting/bye";
    }
}
