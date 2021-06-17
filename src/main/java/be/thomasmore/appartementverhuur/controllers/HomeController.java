package be.thomasmore.appartementverhuur.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {
    private Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping({"/", "/home"})
    public String home(Model model, Principal principal) {

        final String loginName = (principal != null) ? principal.getName() : "NOBODY";
        logger.info("homelogged in" + loginName);

        model.addAttribute("loginName", loginName);


        return "home";
    }

    @GetMapping("/galerij")
    public String galerij() {
        return "galerij";
    }


}
