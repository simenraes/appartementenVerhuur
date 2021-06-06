package be.thomasmore.appartementverhuur.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping({"/", "/home"})
    public String home() {


        return "home";
    }

//   @GetMapping({"/appartementdetails","/appartementdetails/{appartementNaam}"})
//    public String details(Model model,
//                          @PathVariable(required = false) String appartementNaam){
//        model.addAttribute("appartementNaam", (appartementNaam!=null) ? appartementNaam : "geen appartement gekozen");
//        return "appartementdetails";
//   }


}
