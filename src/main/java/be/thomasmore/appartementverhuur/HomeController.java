package be.thomasmore.appartementverhuur;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(@RequestParam(required = false) String naam, Model model) {
        if (naam == null || naam.equals(""))
            naam = "Anonymous";
        model.addAttribute("name", naam);

        model.addAttribute("naam","Anonymous");
        return "home";
    }

}
