package be.thomasmore.appartementverhuur.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class HomeController {
    private Logger logger = LoggerFactory.getLogger(HomeController.class);


    @GetMapping({"/", "/home"})
    public String home(Model model, Principal principal) {
        final String loginName = (principal !=null)? principal.getName() : "NOBODY";
        logger.info("homelogged in" +loginName);
        model.addAttribute("loginName", loginName);


        return "home";
    }

//   @GetMapping({"/appartementdetails","/appartementdetails/{appartementNaam}"})
//    public String details(Model model,
//                          @PathVariable(required = false) String appartementNaam){
//        model.addAttribute("appartementNaam", (appartementNaam!=null) ? appartementNaam : "geen appartement gekozen");
//        return "appartementdetails";
//   }

    @GetMapping("/login")
    public String login(Model model,  Principal principal) {
        if (principal!=null) return "redirect:/appartementenlijst";
        return "login";
    }
    @GetMapping("/logout")
    public String logout(Model model, Principal principal) {
        if (principal==null) return "redirect:/appartementenlijst";
        return "logout";
    }
}
