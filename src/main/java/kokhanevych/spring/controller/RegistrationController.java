package kokhanevych.spring.controller;

import javax.validation.Valid;

import kokhanevych.spring.dto.UserDto;
import kokhanevych.spring.entity.User;
import kokhanevych.spring.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public String registerPage(@ModelAttribute ("user") UserDto userDto, ModelMap modelMap) {
        modelMap.put("user", userDto);
        return "user/registration";
    }

    @PostMapping
    public String registerUser(@ModelAttribute ("user") @Valid UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        userService.add(user);
        return "/login";
    }
}
