package com.example.springproject.Service;

import com.example.springproject.Entity.Equipe;
import com.example.springproject.Entity.Universite;
import com.example.springproject.Repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UniversiteService implements IUniversiteService {
    @Autowired
    private UniversiteRepository myRepository;

  public int ajouterUniversite(Universite U) {
    myRepository.save(U);
    if (myRepository.findById((long) U.getIdUniv()).equals(U))
      return 1;
    else
      return 0;
  }

  public Boolean DeleteUniversite(Universite U) {
    myRepository.delete(U);
    return !myRepository.findById((long) U.getIdUniv()).equals(U);
  }

  public Boolean UpdateUniversite(Universite U) {
    myRepository.delete(U);
    return myRepository.findById((long) U.getIdUniv()).equals(U);
  }

  public List<Universite> findAll(Universite U) {
    return (List<Universite>) myRepository.findAll();
  }

  public Universite findById(Universite U) {
    return myRepository.findById((long) U .getIdUniv()).get();
  }
}
