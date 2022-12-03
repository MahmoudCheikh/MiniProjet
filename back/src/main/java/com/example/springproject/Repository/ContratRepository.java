package com.example.springproject.Repository;

import com.example.springproject.Entity.Contrat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContratRepository extends CrudRepository<Contrat,Integer> {

  @Query("select contrat from Contrat contrat join  Universite universite on contrat.etudiant.departement member universite.departementSet where universite.idUniv = ?1 ")
  public List<Contrat> getContratBy(Long x);

  @Query("select c from Contrat c where DATEDIFF(current_date,c.dateFinContrat)<15")
  List<Contrat> dateExpi();

  @Query("select c from Contrat c where DATEDIFF(current_date,c.dateFinContrat)<15 AND current_date < c.dateFinContrat")
  List<Contrat> datePresqueExp();

  @Query("select c from Contrat c where DATEDIFF(c.dateFinContrat,c.dateDebutContrat)>=365")
  List<Contrat> contratDepasseAn();

}
