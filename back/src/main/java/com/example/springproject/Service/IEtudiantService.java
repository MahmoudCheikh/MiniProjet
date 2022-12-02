package com.example.springproject.Service;

import com.example.springproject.Entity.Contrat;
import com.example.springproject.Entity.Etudiant;

import java.util.List;

public interface IEtudiantService {
    int ajouterEtudiant(Etudiant C);

    Boolean deleteEtudiant(Etudiant C);

    Boolean updateEtudiant(Etudiant C);

    List<Etudiant> findAll();

    Etudiant findById(Integer C);

    Contrat affectContratToEtudiant (Contrat c, String nom, String prenom);

}
