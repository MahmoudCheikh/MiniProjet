package com.example.springproject.Service;

import com.example.springproject.Entity.Contrat;

import java.util.List;

public interface IContratService {

    int ajouterContrat(Contrat C);

    Boolean deleteContrat(Contrat C);

    Boolean updateContrat(Contrat C);

    List<Contrat> findAll();

    Contrat findById(Integer C);
}