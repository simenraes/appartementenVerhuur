package be.thomasmore.appartementverhuur.controllers;

import be.thomasmore.appartementverhuur.model.Appartement;
import be.thomasmore.appartementverhuur.repositories.AppartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AppartementController {
    @Autowired
    private AppartementRepository appartementRepository;

    public AppartementController(AppartementRepository appartementRepository) {
        this.appartementRepository = appartementRepository;
    }

    @GetMapping("/appartementenlijst")
    public String appartementenlijst(Model model) {
        Iterable<Appartement> appartementen = appartementRepository.findAll();
        model.addAttribute("appartementen", appartementen);
        return "appartementenlijst";
    }
}
