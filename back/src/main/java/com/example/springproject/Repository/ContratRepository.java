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


}
