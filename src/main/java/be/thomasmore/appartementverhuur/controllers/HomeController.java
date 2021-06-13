package be.thomasmore.appartementverhuur.controllers;

import be.thomasmore.appartementverhuur.model.User;
import be.thomasmore.appartementverhuur.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
public class HomeController {
    private Logger logger = LoggerFactory.getLogger(HomeController.class);
    @Autowired
    private UserRepository userRepository;


    @GetMapping({"/", "/home"})
    public String home(Model model, Principal principal) {

        final String loginName = (principal !=null)? principal.getName() : "NOBODY";
        logger.info("homelogged in" +loginName);

        model.addAttribute("loginName", loginName);


        return "home";
    }
    @GetMapping("/galerij")
    public String galerij(Model model){
        return "galerij";
    }

//   @GetMapping({"/appartementdetails","/appartementdetails/{appartementNaam}"})
//    public String details(Model model,
//                          @PathVariable(required = false) String appartementNaam){
//        model.addAttribute("appartementNaam", (appartementNaam!=null) ? appartementNaam : "geen appartement gekozen");
//        return "appartementdetails";
//   }

}
