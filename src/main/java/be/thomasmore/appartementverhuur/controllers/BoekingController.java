package be.thomasmore.appartementverhuur.controllers;

import be.thomasmore.appartementverhuur.model.Appartement;
import be.thomasmore.appartementverhuur.model.Boeking;
import be.thomasmore.appartementverhuur.repositories.AppartementRepository;
import be.thomasmore.appartementverhuur.repositories.BoekingRepository;
import org.hibernate.validator.constraints.br.TituloEleitoral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class BoekingController {
    @Autowired
    private AppartementRepository appartementRepository;
   @Autowired
    private BoekingRepository boekingRepository;

    @GetMapping("/boekingen")
    public String boekingenLijst(Model model){
        Iterable<Appartement> appartementen = appartementRepository.findAll();
        Iterable<Boeking> boekingen = boekingRepository.findAll();
        model.addAttribute("boekingen", boekingen);
        model.addAttribute("appartementen", appartementen);
        return "boekingen";

    }

}
