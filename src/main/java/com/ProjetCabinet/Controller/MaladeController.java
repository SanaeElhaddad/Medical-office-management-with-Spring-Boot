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

import com.ProjetCabinet.Service.MaladeService;
import com.ProjetCabinet.model.Malade;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/malade")
public class MaladeController {
	 @Autowired
	    private MaladeService maladeService;
		
	    @GetMapping("")
	    public String getAllPatiens(Model model) {
	        List<Malade> patientsList = maladeService.getAllMalades();
	        model.addAttribute("maladetsList", patientsList);
	        return "malade/index";
	    }
	    @GetMapping("/add")
	    public String showAddPatientForm(@ModelAttribute Malade malade) {
	        return "malade/Ajouter";
	    }
	    
//	    @PostMapping("/add")
//	    public String addPatient(@ModelAttribute Malade malade) {
//	        maladeService.createOrUpdatePatient(malade);
//	        return "redirect:/malade";
//	    }
	    @PostMapping("/add")
	    public String addPatient(@Valid @ModelAttribute Malade malade, BindingResult bindingResult) {
	        if (bindingResult.hasErrors()) {
	            return "malade/Ajouter"; 
	        }
	        maladeService.createOrUpdatePatient(malade);
	        return "redirect:/malade";
	    }
	 
	    @GetMapping("/edit/{id}")
	    public String showEditPatientForm(@PathVariable Long id,Model model) {

	    	model.addAttribute("malade", maladeService.getmaladById(id));
	    	
	        return "malade/Ajouter";
	    }
	    @GetMapping("/delete/{id}")
	    public String deletePatient(@PathVariable Long id) {
	    	maladeService.deletePMalade(id);
	        return "redirect:/malade";
	    }

}
