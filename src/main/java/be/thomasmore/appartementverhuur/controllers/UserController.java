package be.thomasmore.appartementverhuur.controllers;

import be.thomasmore.appartementverhuur.model.User;
import be.thomasmore.appartementverhuur.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
//    @Autowired
//    private AuthenticationManager authenticationManager;


    @GetMapping("/registreer")
    public String register(Model model, Principal principal) {
        if (principal != null) return "redirect:/appartementenlijst";
        return "user/registreer";
    }
    @PostMapping("/registreer")
    public String registerPost(Model model, Principal principal,
                               @RequestParam String username,
                               @RequestParam String password,
                               @RequestParam String email) {
        if (principal != null) return "redirect:/appartementenlijst";
        if (username == null || username.isBlank()) return "redirect:/appartementenlijst";// kan niet redirecten naar
        // register ?
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) return "redirect:/appartementenlijst";

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setRole("USER");
        newUser.setEmail(email);
        String encode = passwordEncoder.encode(password);
        newUser.setPassword(encode);
        userRepository.save(newUser);


//        autologin(username, password);

        return "redirect:/appartementenlijst";
    }
}
