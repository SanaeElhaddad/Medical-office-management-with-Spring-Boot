package com.ProjetCabinet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjetCabinet.model.Medecin;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {

}
