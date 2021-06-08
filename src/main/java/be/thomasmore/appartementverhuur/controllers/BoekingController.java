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
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

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
    @GetMapping({"/boekingdetails", "/boekingdetails/{id}"})
    public String boekinDetails(Model model,
                                @PathVariable(required = false) Integer id){
        if (id == null) return "boekingdetails";
        Optional<Boeking> optionalBoeking = boekingRepository.findById(id);
        Iterable<Appartement> appartementen = appartementRepository.findAll();
        if (optionalBoeking.isPresent()) {
            long nrOfBoekingen = boekingRepository.count();
            model.addAttribute("boeking", (optionalBoeking.get()));
            model.addAttribute("prevId", id > 1 ? id - 1 : nrOfBoekingen);
            model.addAttribute("nextId", id < nrOfBoekingen ? id + 1 : 1);
            model.addAttribute("appartementen", appartementen);



        }

//        Iterable<Appartement> appartementen = appartementRepository.findAll();
//        Iterable<Boeking> boekingen = boekingRepository.findAll();
//        model.addAttribute("boekingen", boekingen);
//        model.addAttribute("appartementen", appartementen);

        return "boekingdetails";

    }

}
