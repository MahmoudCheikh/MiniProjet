package com.example.springproject.Service;

import com.example.springproject.Entity.Paiement;
import com.example.springproject.Repository.PaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaiementService implements IPaiementService{

    @Autowired
    private PaiementRepository PaiementRepository;

    @Override
    public int ajouterPaiement(Paiement P) {
        PaiementRepository.save(P);
        return 1;
    }

    @Override
    public Boolean deletePaiement(Paiement P) {
        PaiementRepository.delete(P);
        return true;
    }

    @Override
    public Boolean updatePaiement(Paiement P) {
        PaiementRepository.save(P);
        return  PaiementRepository.findById((Integer) P.getIdPaiement()).equals(P);
    }

    @Override
    public List<Paiement> findAll() {
        return (List<Paiement>) PaiementRepository.findAll();
    }

    @Override
    public Paiement findById(Integer P) {
        return PaiementRepository.findById(P).get();
    }


}


