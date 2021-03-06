package be.thomasmore.appartementverhuur.controllers;

import be.thomasmore.appartementverhuur.model.Appartement;
import be.thomasmore.appartementverhuur.model.Boeking;
import be.thomasmore.appartementverhuur.repositories.AppartementRepository;
import be.thomasmore.appartementverhuur.repositories.BoekingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller

public class BoekingController {
    private Logger logger = LoggerFactory.getLogger(BoekingController.class);

    @Autowired
    private AppartementRepository appartementRepository;
    @Autowired
    private BoekingRepository boekingRepository;

    @GetMapping("/boekingen")
    public String boekingenLijst(Model model) {
        Iterable<Appartement> appartementen = appartementRepository.findAll();
        Iterable<Boeking> boekingen = boekingRepository.findAll();
        model.addAttribute("boekingen", boekingen);
        model.addAttribute("appartementen", appartementen);
        return "boekingen";

    }


    @GetMapping({"/boekingdetails", "/boekingdetails/{id}"})
    public String boekingDetails(Model model,
                                 @PathVariable(required = false) Integer id) {
        if (id == null) return "boekingdetails";
        Optional<Boeking> optionalBoeking = boekingRepository.findById(id);
        Iterable<Appartement> appartementen = appartementRepository.findAll();
        if (optionalBoeking.isPresent()) {

            model.addAttribute("boeking", (optionalBoeking.get()));
            model.addAttribute("appartementen", appartementen);


        }


        return "boekingdetails";

    }

    @ModelAttribute("boeking")
    public Boeking findBoeking(@PathVariable(required = false) Integer id) {
        //Spring roept eerst de @ModelAttribute functie (findParty) op. Die functie heeft een PathVariable id. Spring gebruikt hiervoor dezelfde parameter als in de  Request Handler. Maar de Request Handler partyNew heeft geen PathVariable.
        logger.info("findBoeking " + id);
        if (id == null) return new Boeking();


        Optional<Boeking> optionalBoeking = boekingRepository.findById(id);
        return optionalBoeking.orElse(null);


    }

    @GetMapping("/boekingnew")
    public String boekingNew(Model model) {
        model.addAttribute("boeking", new Boeking());
        model.addAttribute("boekingen", boekingRepository.findAll());
        model.addAttribute("appartementen", appartementRepository.findAll());
        return "boekingnew";

    }

    @PostMapping("/boekingnew")
    public String boekinNewPost(@ModelAttribute("boeking") Boeking boeking) {

        Boeking newBoeking = boekingRepository.save(boeking);
        return "redirect:/boekingdetails/" + newBoeking.getId();

    }

}
