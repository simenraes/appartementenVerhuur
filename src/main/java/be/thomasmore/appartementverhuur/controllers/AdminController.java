package be.thomasmore.appartementverhuur.controllers;

import be.thomasmore.appartementverhuur.model.Appartement;
import be.thomasmore.appartementverhuur.repositories.AppartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AppartementRepository appartementRepository;

    @GetMapping("/appartementedit/{id}")
    public String appartementEdit(Model model,
                                  @PathVariable int id) {

        Optional<Appartement> optionalAppartement = appartementRepository.findById(id);
        if (optionalAppartement.isPresent()) {
            model.addAttribute("appartement", optionalAppartement.get());

        }
        return "admin/appartementedit";
    }
}
