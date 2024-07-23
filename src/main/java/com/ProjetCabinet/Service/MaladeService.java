package com.ProjetCabinet.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetCabinet.Repository.MaladeRepository;
import com.ProjetCabinet.model.Malade;

@Service
public class MaladeService {
    @Autowired
    private MaladeRepository maladeRepository;

    public List<Malade> getAllMalades() {
        return maladeRepository.findAll();
    }

    public Malade getmaladById(Long id) {
        return maladeRepository.findById(id).orElse(null);
    }

    public Malade createOrUpdatePatient(Malade malade) {
        return maladeRepository.save(malade);
    }

    public void deletePMalade(Long id) {
        maladeRepository.deleteById(id);
    }
    public long getNumberOfPatients() {
        return maladeRepository.count();    }

}
