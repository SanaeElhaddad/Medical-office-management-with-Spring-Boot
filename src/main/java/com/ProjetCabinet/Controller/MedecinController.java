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

import com.ProjetCabinet.Service.MedecinService;
import com.ProjetCabinet.model.Medecin;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/medecin")
public class MedecinController {
	  @Autowired
	    private MedecinService medecinService;
		
//	  @GetMapping("/home")
//	    public String afficheIndex() {
//	        return "Medecin/home";
//	    }
	    @GetMapping("")
	    public String getAllMedecins(Model model) {
	        List<Medecin> medecinsList = medecinService.getAllMedecins();
	        model.addAttribute("medecinsList", medecinsList);
	        return "Medecin/index";
	    }
	    @GetMapping("/add")
	    public String showAddMedecinForm(@ModelAttribute Medecin medecin) {
	        return "Medecin/Ajouter";
	    }
	    
//	    @PostMapping("/add")
//	    public String addMedecin(@ModelAttribute Medecin medecin) {
//	        medecinService.createOrUpdateMedcin(medecin);
//	        return "redirect:/medecin";
//	    }
	    @PostMapping("/add")
	    public String addMedecin(@Valid @ModelAttribute Medecin medecin, BindingResult bindingResult) {
	        if (bindingResult.hasErrors()) {
	            return "Medecin/Ajouter"; 
	        }
	        medecinService.createOrUpdateMedcin(medecin);
	        return "redirect:/medecin";
	    }
	 
	    @GetMapping("/edit/{id}")
	    public String showEditMedecinForm(@PathVariable Long id,Model model) {

	    	model.addAttribute("medecin", medecinService.getMedecinById(id));
	    	
	        return "Medecin/Ajouter";
	    }
	    @GetMapping("/delete/{id}")
	    public String deleteMedecin(@PathVariable Long id) {
	        medecinService.deleteMedecin(id);
	        return "redirect:/medecin";
	    }
}
