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
import org.springframework.web.bind.annotation.PostMapping;
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



//    public AppartementController(AppartementRepository appartementRepository) {
//        this.appartementRepository = appartementRepository;
//    }

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
                                              @RequestParam(required = false) String filterHuisdieren) {
//        logger.info(String.format("appartementenlijstMetFilter -- min=%d, max=%d, maxAfstandTotCentrum=%d", minCapacity,
//                maxCapacity, maxAfstandTotCentrum));
//        Boolean huisdierentoegelatenJPQL =
//                (filterHuisdierentoegelaten == null || filterHuisdierentoegelaten.equals("all")) ? null : filterHuisdierentoegelaten.equals("yes");

//        List<Appartement> appartementen = appartementRepository.findByFilter(minCapacity, maxCapacity,
//                maxAfstandTotCentrum, filterStringToBoolean(filterHuisdieren));
//        List<Appartement> appartementen = appartementRepository.findByFilter(minCapacity, maxCapacity, maxAfstandTotCentrum,
//                filterStringToBoolean(filterHuisdieren));

        Boolean foodForJPQL = (filterHuisdieren == null || filterHuisdieren.equals("all")) ? null : filterHuisdieren.equals("yes");
        List<Appartement> appartementen = appartementRepository.findByFilter(minCapacity, maxCapacity, maxAfstandTotCentrum,
                foodForJPQL);
//        List<Appartement> appartementen= appartementRepository.findByCapacityGreaterThanEqual(minCapacity);
//        List<Appartement> appartementen= appartementRepository.findByFilter(minCapacity, maxCapacity);
//
//        List<Appartement> appartementen;
//        if (minCapacity != null)
//            if (maxCapacity != null) //min!=null and max!=null
//                appartementen = appartementRepository.findByCapacityBetween(minCapacity, maxCapacity);
//            else //min!=null and max==null
//                appartementen = appartementRepository.findByCapacityBetween(minCapacity, maxCapacity);
//        else // min==null
//            if (maxCapacity != null) //min==null and max!=null
//                appartementen = appartementRepository.findByCapacityBetween(minCapacity, maxCapacity);
//            else //min==null and max==null
//                appartementen = appartementRepository.findByCapacityBetween(minCapacity, maxCapacity);

//        if (keyword == null)
//            appartementen = appartementRepository.findByCapacityBetween(minCapacity, maxCapacity, keyword);
//        else
//            appartementen = appartementRepository.findByCapacityBetween(minCapacity, maxCapacity, keyword);


        model.addAttribute("appartementen", appartementen);
        model.addAttribute("nrOfAppartementen", appartementen.size());

        model.addAttribute("showFilters", true);
        model.addAttribute("minCapacity", minCapacity);
        model.addAttribute("maxCapacity", maxCapacity);
        model.addAttribute("maxAfstandTotCentrum", maxAfstandTotCentrum);
        model.addAttribute("filterhuisdieren", filterHuisdieren);
//        model.addAttribute("keyword", keyword);

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
//   @GetMapping("/appartementenlijst/huisdierentoegelaten/yes")
//    public String appartementenlijstHuisdierenToegelatenYes(Model model){
//        Iterable<Appartement> appartementen= appartementRepository.findByHuisdierenToegelaten(true);
//        model.addAttribute("appartementen", appartementen);
//        return "appartementenlijst";
//   }
//    @GetMapping("/appartementenlijst/capacitygreaterthanequal/mincapacity")
//    public String appartementenlijstCapacityGreaterThanEqual(Model model,
//                                                             @RequestParam(required = false) Integer minCapacity){
//        List<Appartement> appartementen= appartementRepository.findByCapacityGreaterThanEqual(minCapacity);
//
//        model.addAttribute("appartementen", appartementen);
//        model.addAttribute("nrOfVenues", appartementen.size());
//        return "appartementenlijst";
//    }

//    private Boolean filterStringToBoolean(String filterString) {
//        return (filterString == null || filterString.equals("all")) ? null : filterString.equals("yes");
//    }
}


