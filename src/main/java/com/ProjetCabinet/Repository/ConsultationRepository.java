package com.ProjetCabinet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ProjetCabinet.model.Consultation;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
	
    @Query("SELECT SUM(c.prix) FROM Consultation c")
    Double sumPrix();

}
