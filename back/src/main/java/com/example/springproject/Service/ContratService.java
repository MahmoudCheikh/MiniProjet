package com.example.springproject.Service;

import com.example.springproject.Entity.Contrat;
import com.example.springproject.Repository.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratService implements IContratService {
    @Autowired
    private ContratRepository myRepository;

    @Override
    public int ajouterContrat(Contrat C) {
        myRepository.save(C);
        return 1;
    }

    @Override
    public Boolean deleteContrat(Contrat C) {
        myRepository.delete(C);
        return true;
    }


    @Override
    public Boolean updateContrat(Contrat C) {
        myRepository.save(C);
        return  myRepository.findById((Integer) C.getIdContrat()).equals(C);
    }

    @Override
    public List<Contrat> findAll() {
        return (List<Contrat>) myRepository.findAll();
    }

    @Override
    public Contrat findById(Integer C) {
        return myRepository.findById(C).get();
    }
}