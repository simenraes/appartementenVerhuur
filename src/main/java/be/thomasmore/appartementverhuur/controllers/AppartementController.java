package be.thomasmore.appartementverhuur.controllers;

import be.thomasmore.appartementverhuur.model.Appartement;
import be.thomasmore.appartementverhuur.repositories.AppartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;


@Controller
public class AppartementController {
    @Autowired
    private AppartementRepository appartementRepository;

    public AppartementController(AppartementRepository appartementRepository) {
        this.appartementRepository = appartementRepository;
    }

    @GetMapping("/appartementenlijst")
    public String appartementenlijst(Model model) {
        long nrOfAppartementen = appartementRepository.count();
        Iterable<Appartement> appartementen = appartementRepository.findAll();
        model.addAttribute("appartementen", appartementen);
        model.addAttribute("nrOfAppartementen", nrOfAppartementen);
        return "appartementenlijst";
    }

    @GetMapping({"/appartementdetails", "/appartementdetails/{id}"})
    public String appartementDetails(Model model,
                               @PathVariable(required = false) Integer id) {
        if (id == null) return "appartementdetails";

        Optional<Appartement> optionalAppartement = appartementRepository.findById(id);
        if (optionalAppartement.isPresent()) {
            long nrOfVAppartementen = appartementRepository.count();
            model.addAttribute("appartement", (optionalAppartement.get()));
            model.addAttribute("prevId", id > 1 ? id - 1 : nrOfVAppartementen);
            model.addAttribute("nextId", id < nrOfVAppartementen ? id + 1 : 1);



        }
        return "appartementdetails";
    }
}


