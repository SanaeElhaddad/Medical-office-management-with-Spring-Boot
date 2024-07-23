package com.ProjetCabinet.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ProjetCabinet.Service.ConsultationService;
import com.ProjetCabinet.Service.MaladeService;
import com.ProjetCabinet.Service.MedecinService;
import com.ProjetCabinet.model.Consultation;
import com.ProjetCabinet.model.Malade;
import com.ProjetCabinet.model.Medecin;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/consultation")
public class ConsultationController {
	

    @Autowired
    private ConsultationService consultationService;
    @Autowired
    private MedecinService medecinService;
    @Autowired
    private MaladeService maladeService;

    @GetMapping("")
    public String getAllRendezVous(Model model) {
        List<Consultation> consultationList = consultationService.getAllConsultation();
        model.addAttribute("consultationList", consultationList);
        return "consultation/index";
    }

    @GetMapping("/add")
    public String showAddRendezVousForm(@ModelAttribute Consultation consultation, Model model) {
        List<Medecin> medecinsList = medecinService.getAllMedecins();
        List<Malade> maladeList = maladeService.getAllMalades();

        model.addAttribute("medecinsList", medecinsList);
        model.addAttribute("maladeList", maladeList);

        return "consultation/ajouter";
    }

//    @PostMapping("/add")
//    public String addRendezVous(@ModelAttribute Consultation consultation) {
//        consultationService.createOrUpdateConsultation(consultation);
//        return "redirect:/consultation";
//    }
    @PostMapping("/add")
    public String addRendezVous(Model model,@Valid @ModelAttribute Consultation consultation, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
        	List<Medecin> medecinsList = medecinService.getAllMedecins();
            List<Malade> maladeList = maladeService.getAllMalades();
            model.addAttribute("medecinsList", medecinsList);
            model.addAttribute("maladeList", maladeList);
            return "consultation/ajouter"; 
        }
        consultationService.createOrUpdateConsultation(consultation);
        return "redirect:/consultation";
    }

    @GetMapping("/edit/{id}")
    public String showEditRendezVousForm(@PathVariable Long id, Model model) {
        Consultation consultation = consultationService.getConsultationById(id);
        List<Medecin> medecinsList = medecinService.getAllMedecins();
        List<Malade> maladeList = maladeService.getAllMalades();

        model.addAttribute("consultation", consultation);
        model.addAttribute("medecinsList", medecinsList);
        model.addAttribute("maladeList", maladeList);

        return "consultation/ajouter";
    }

    @GetMapping("/delete/{id}")
    public String deleteRendezVous(@PathVariable Long id) {
        consultationService.deleteConsultation(id);
        return "redirect:/consultation";
    }

}
