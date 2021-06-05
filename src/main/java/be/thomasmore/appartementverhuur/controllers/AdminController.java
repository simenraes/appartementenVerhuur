package be.thomasmore.appartementverhuur.controllers;

import be.thomasmore.appartementverhuur.model.Appartement;
import be.thomasmore.appartementverhuur.repositories.AppartementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//import javax.validation.Valid;

public class AdminController {
    @Autowired
    private AppartementRepository appartementRepository;
    private Logger logger = LoggerFactory.getLogger(AdminController.class);

    @GetMapping("/appartementnew")
    public String appartementNew(Model model) {
        logger.info("appartementnew ");
        model.addAttribute("appartement", new Appartement());
        model.addAttribute("appartementen", appartementRepository.findAll());

        return "admin/appartementnew";
    }

//    @PostMapping("/appartementnew")
//    public String createTable(@Valid Appartement appartement,
//                              Errors errors, Model model) {
//        if (errors.hasErrors()) {
//            model.addAttribute("appartementen", appartementRepository.findAll());
//            return "admin/appartementnew";
//        } else {
//            appartementRepository.save(appartement);
//            return "redirect:/"; // niet zeker
//        }
//    }
}
