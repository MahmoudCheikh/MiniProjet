package com.example.springproject.Service;

import com.example.springproject.Entity.Paiement;

import java.util.List;

public interface IPaiementService {

    int ajouterPaiement(Paiement P);

    Boolean deletePaiement(Paiement P);

    Boolean updatePaiement(Paiement P);

    List<Paiement> findAll();

    Paiement findById(Integer C);


}
