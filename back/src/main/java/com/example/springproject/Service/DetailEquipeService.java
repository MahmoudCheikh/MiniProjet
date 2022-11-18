package com.example.springproject.Service;

import com.example.springproject.Entity.Departement;
import com.example.springproject.Entity.DetailEquipe;
import com.example.springproject.Repository.DetailEquipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DetailEquipeService implements IDetailEquipeService {
    @Autowired
    private DetailEquipRepository myRepository;

  public int ajouterDetailEquipe(DetailEquipe D) {
    myRepository.save(D);
    if (myRepository.findById((long) D.getSalle()).equals(D))
      return 1;
    else
      return 0;
  }

  public Boolean DeleteDetailEquip(DetailEquipe D) {
    myRepository.delete(D);
    return !myRepository.findById((long) D.getSalle()).equals(D);
  }

  public Boolean UpdateDetailEquipe(DetailEquipe D) {
    myRepository.delete(D);
    return myRepository.findById((long) D.getSalle()).equals(D);
  }

  public List<DetailEquipe> findAll(DetailEquipe D) {
    return (List<DetailEquipe>) myRepository.findAll();
  }

  public DetailEquipe findById(DetailEquipe D) {
    return myRepository.findById((long) D.getSalle()).get();
  }
}
