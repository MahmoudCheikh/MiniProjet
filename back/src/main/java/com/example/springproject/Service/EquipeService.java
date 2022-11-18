package com.example.springproject.Service;

import com.example.springproject.Entity.Equipe;
import com.example.springproject.Repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EquipeService implements IEquipeService {
    @Autowired
    private EquipeRepository myRepository;

  public int ajouterEquipe(Equipe E) {
    myRepository.save(E);
    if (myRepository.findById((long) E.getIdEquipe()).equals(E))
      return 1;
    else
      return 0;
  }

  public Boolean DeleteEquipe(Equipe E) {
    myRepository.delete(E);
    return !myRepository.findById((long) E.getIdEquipe()).equals(E);
  }

  public Boolean UpdateEquipe(Equipe E) {
    myRepository.delete(E);
    return myRepository.findById((long) E.getIdEquipe()).equals(E);
  }

  public List<Equipe> findAll(Equipe E) {
    return (List<Equipe>) myRepository.findAll();
  }

  public Equipe findById(Equipe E) {
    return myRepository.findById((long) E.getIdEquipe()).get();
  }
}
