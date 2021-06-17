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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;


@Controller
public class AppartementController {
    private Logger logger = LoggerFactory.getLogger(AppartementController.class);

    @Autowired
    private AppartementRepository appartementRepository;
    @Autowired
    private BoekingRepository boekingRepository;


    @GetMapping({"/appartementenlijst"})
    public String appartementenlijst(Model model) {
        logger.info("appartementenlijst");
        Iterable<Appartement> appartementen = appartementRepository.findAll();
        long nrOfAppartementen = appartementRepository.count();
        model.addAttribute("appartementen", appartementen);
        model.addAttribute("nrOfAppartementen", nrOfAppartementen);
        model.addAttribute("showFilters", false);
        return "appartementenlijst";
    }

    @GetMapping({"/appartementenlijst/filter"})
    public String appartementenlijstMetFilter(Model model,
                                              @RequestParam(required = false) Integer minCapacity,
                                              @RequestParam(required = false) Integer maxCapacity,
                                              @RequestParam(required = false) Integer maxAfstandTotCentrum,
                                              @RequestParam(required = false) String filterHuisdieren,
                                              @RequestParam(required = false) String keyword) {


        Boolean huisdierenForJPQL = (filterHuisdieren == null || filterHuisdieren.equals("all")) ? null : filterHuisdieren.equals("yes");
        List<Appartement> appartementen = appartementRepository.findByFilter(minCapacity, maxCapacity, maxAfstandTotCentrum,
                huisdierenForJPQL, keyword);

        model.addAttribute("appartementen", appartementen);
        model.addAttribute("nrOfAppartementen", appartementen.size());

        model.addAttribute("showFilters", true);
        model.addAttribute("minCapacity", minCapacity);
        model.addAttribute("maxCapacity", maxCapacity);
        model.addAttribute("maxAfstandTotCentrum", maxAfstandTotCentrum);
        model.addAttribute("filterHuisdieren", filterHuisdieren);
        model.addAttribute("keyword", keyword);

        return "appartementenlijst";

    }

    @GetMapping({"/appartementdetails", "/appartementdetails/{id}"})
    public String appartementDetails(Model model,
                                     @PathVariable(required = false) Integer id) {
        if (id == null) return "appartementdetails";

        Optional<Appartement> optionalAppartement = appartementRepository.findById(id);

        if (optionalAppartement.isPresent()) {

            long nrOfVAppartementen = appartementRepository.count();
            Iterable<Boeking> boekingen = boekingRepository.findByAppartement(optionalAppartement.get());

            model.addAttribute("appartement", (optionalAppartement.get()));
            model.addAttribute("prevId", id > 1 ? id - 1 : nrOfVAppartementen);
            model.addAttribute("nextId", id < nrOfVAppartementen ? id + 1 : 1);
            model.addAttribute("boekingen", boekingen);


        }
        return "appartementdetails";
    }
}


