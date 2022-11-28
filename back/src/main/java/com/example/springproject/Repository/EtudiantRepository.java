package com.example.springproject.Repository;

import com.example.springproject.Entity.Etudiant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends CrudRepository<Etudiant,Integer> {
   /* @Query("select e from Etudiant e where e.nomE=?1 and e.prenomE=?2 ")
    Etudiant findEtudiantByNomPrenom(String nom,String prenom);*/
    Etudiant findOneByNomEAndPrenomE(String nomE, String prenomE);
}
