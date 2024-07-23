package com.ProjetCabinet.Service;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetCabinet.Repository.ConsultationRepository;
import com.ProjetCabinet.model.Consultation;


@Service
public class ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;

    public List<Consultation> getAllConsultation() {
        return consultationRepository.findAll();
    }

    public Consultation getConsultationById(Long id) {
        return consultationRepository.findById(id).orElse(null);
    }

    public Consultation createOrUpdateConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    public void deleteConsultation(Long id) {
    	consultationRepository.deleteById(id);
    }
    public long getNumberOfConsultations() {
        return consultationRepository.count();    }
    
    public String getTotalPrix() {
        Double totalPrix = consultationRepository.sumPrix();
        DecimalFormat df = new DecimalFormat("#0.00"); // Format avec deux décimales
        return totalPrix != null ? df.format(totalPrix) : "0.00";
    }
}
