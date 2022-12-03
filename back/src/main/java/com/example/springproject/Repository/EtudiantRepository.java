package com.example.springproject.Repository;

import com.example.springproject.Entity.Etudiant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtudiantRepository extends CrudRepository<Etudiant,Integer> {
   /* @Query("select e from Etudiant e where e.nomE=?1 and e.prenomE=?2 ")
    Etudiant findEtudiantByNomPrenom(String nom,String prenom);*/
   List<Etudiant> findByDepartement(Integer idDepart);

 @Query("select e from Etudiant e where e.nomE=?1 and e.prenomE=?2")
 Etudiant findEtudiantByNomPrenom(String nomE,String prenomE);

 @Query("select e from Etudiant e inner join e.departement ee where ee.idDepart = ?1")
 List<Etudiant> findEtudiantByDepartement    (Integer idDepart);
}
