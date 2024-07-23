package com.ProjetCabinet.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ProjetCabinet.Service.ConsultationService;
import com.ProjetCabinet.Service.MaladeService;
import com.ProjetCabinet.Service.MedecinService;


@Controller
@RequestMapping("")
public class homeController {
	
    @Autowired
    private MedecinService medecinService;
    
    @Autowired
    private MaladeService maladeService; 
    
    @Autowired
    private ConsultationService consultationService;
    
    
    @GetMapping("")
    public String dashboard(Model model) {
        long numberOfMedecins = medecinService.getNumberOfMedecins();
        long numberOfPatients = maladeService.getNumberOfPatients();
        long numberOfConsultations = consultationService.getNumberOfConsultations();
        String TotalEarning = consultationService.getTotalPrix();
        model.addAttribute("numberOfMedecins", numberOfMedecins);
        model.addAttribute("numberOfPatients", numberOfPatients);
        model.addAttribute("numberOfConsultations", numberOfConsultations);
        model.addAttribute("TotalEarning", TotalEarning);
        return "home/dashboard";
    }

}
