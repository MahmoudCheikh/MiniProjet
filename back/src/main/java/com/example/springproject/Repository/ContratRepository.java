package com.example.springproject.Repository;

import com.example.springproject.Entity.Contrat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ContratRepository extends CrudRepository<Contrat,Integer> {

  @Query("select contrat from Contrat contrat join  Universite universite on contrat.etudiant.departement member universite.departementSet where universite.idUniv = ?1 ")
  public List<Contrat> getContratBy(Long x);

  @Query("select  count (c) from Contrat c where c.dateFinContrat<=?1 and c.dateDebutContrat>=?2")
  Integer countContratByDateDebutContratAfterAndDateFinContratBefore(Date dateFinContrat,Date dateDebutContrat);


  @Query("select  SUM(c.montantContrat) from Contrat c where c.dateFinContrat<=?2 and c.dateDebutContrat>=?1")
  float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);

  @Query("select c from Contrat c where   c.dateDebutContrat>=?1 and c.dateFinContrat<=?2")
  List<Contrat> contratBetween2dates(Date startDate, Date endDate);


  @Query("select  c from Contrat c where DATEDIFF(current_date,c.dateFinContrat)=-15")
  List<Contrat> dateExpi();

  @Query("select c from Contrat c where DATEDIFF(c.dateFinContrat,c.dateDebutContrat)>=365")
  List<Contrat> contratDepasseAn();


}
