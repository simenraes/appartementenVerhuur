package be.thomasmore.appartementverhuur.controllers;

import be.thomasmore.appartementverhuur.model.Boeking;
import be.thomasmore.appartementverhuur.model.Huurder;
import be.thomasmore.appartementverhuur.repositories.BoekingRepository;
import be.thomasmore.appartementverhuur.repositories.HuurderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class HuurderController {
    private final Logger logger = LoggerFactory.getLogger(HuurderController.class);
    @Autowired
    private HuurderRepository huurderRepository;
    @Autowired
    private BoekingRepository boekingRepository;


    @GetMapping({"/huurderdetails", "/huurderdetails/{id}"})
    public String huurderDetails(Model model,
                                @PathVariable(required = false) Integer id) {
        if (id == null) return "huurderdetails";

        Optional<Huurder> optionalHuurder = huurderRepository.findById(id);
        Iterable<Boeking> boekingen= boekingRepository.findAll();
        if (optionalHuurder.isPresent()) {
            long nrOfHuurders = huurderRepository.count();
            model.addAttribute("huurder", optionalHuurder.get());
            model.addAttribute("boekingen", boekingen);
            model.addAttribute("prevId", id > 1 ? id - 1 : nrOfHuurders);
            model.addAttribute("nextId", id < nrOfHuurders ? id + 1 : 1);
        }
        return "huurderdetails";
    }

}
