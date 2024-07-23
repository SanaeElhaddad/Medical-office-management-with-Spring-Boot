package com.ProjetCabinet.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetCabinet.Repository.MedecinRepository;
import com.ProjetCabinet.model.Medecin;
@Service
public class MedecinService {
	@Autowired
    private MedecinRepository medecinRepository;

    public List<Medecin> getAllMedecins() {
        return medecinRepository.findAll();
    }

    public Medecin getMedecinById(Long id) {
        return medecinRepository.findById(id).orElse(null);
    }

    public Medecin createOrUpdateMedcin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    public void deleteMedecin(Long id) {
        medecinRepository.deleteById(id);
    }
    public long getNumberOfMedecins() {
        return medecinRepository.count();    }
}
