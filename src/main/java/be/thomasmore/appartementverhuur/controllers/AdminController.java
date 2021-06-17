package be.thomasmore.appartementverhuur.controllers;

import be.thomasmore.appartementverhuur.model.Appartement;
import be.thomasmore.appartementverhuur.repositories.AppartementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AppartementRepository appartementRepository;


    @ModelAttribute("appartement")
    public Appartement findAppartement(@PathVariable(required = false) Integer id) {
        //Spring roept eerst de @ModelAttribute functie (findParty) op. Die functie heeft een PathVariable id. Spring gebruikt hiervoor dezelfde parameter als in de  Request Handler. Maar de Request Handler partyNew heeft geen PathVariable.
        logger.info("findAppartement " + id);
        if (id == null) return new Appartement();


        Optional<Appartement> optionalAppartement = appartementRepository.findById(id);
        return optionalAppartement.orElse(null);
    }

    @GetMapping("/appartementedit/{id}")
    public String appartementEdit() {


        return "admin/appartementedit";
    }

    @PostMapping("/appartementedit/{id}")
    public String appartementEditPost(Model model,
                                      @PathVariable int id,
                                      @ModelAttribute("appartement") Appartement appartement) {

        Optional<Appartement> optionalAppartement = appartementRepository.findById(id);
        if (optionalAppartement.isPresent()) {
            Appartement editedAppartement = optionalAppartement.get();
            editedAppartement.setExtraInfo(appartement.getExtraInfo());
            editedAppartement.setCapacity(appartement.getCapacity());
            editedAppartement.setIsParkingBeschikbaar(appartement.isParkingBeschikbaar());
            editedAppartement.setAppartementNaam(appartement.getAppartementNaam());
            appartementRepository.save(appartement);
            model.addAttribute("appartement", editedAppartement);
        }
        return "redirect:/appartementdetails/" + id;
    }

    @GetMapping("/appartementnew")
    public String appartementNew(Model model) {
        model.addAttribute("appartement", new Appartement());
        model.addAttribute("appartementen", appartementRepository.findAll());
        return "admin/appartementnew";
    }

    @PostMapping("/appartementnew")
    public String appartementNewPost(Model model,
                                     @ModelAttribute("appartement") Appartement appartement) {

        Appartement newAppartement = appartementRepository.save(appartement);
        return "redirect:/appartementdetails/" + newAppartement.getId();

    }


}


