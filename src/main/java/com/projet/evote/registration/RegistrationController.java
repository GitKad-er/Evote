package com.projet.evote.registration;

import com.projet.evote.dtos.UserDto;
import com.projet.evote.user.User;
import com.projet.evote.user.UserAlreadyExistException;
import com.projet.evote.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Validated
@RestController
@RequestMapping(path = "registration")
@AllArgsConstructor
public class RegistrationController {
    @Autowired
    UserService userService;

    @GetMapping("/user")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }


    public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid UserDto userDto,
                                            HttpServletRequest request, Errors errors) {
        try {
            User registered = userService.registerNewUserAccount(userDto);
        } catch (UserAlreadyExistException uaeEx) {
            ModelAndView mav = new ModelAndView();
            mav.addObject("message", "Un compte est déjà associé à ctte adresse email");
            return mav;
        }

        return new ModelAndView("successRegister", "user", userDto);

    }
}
