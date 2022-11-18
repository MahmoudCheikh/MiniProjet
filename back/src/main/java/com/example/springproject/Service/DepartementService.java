package com.example.springproject.Service;

import com.example.springproject.Entity.Contrat;
import com.example.springproject.Entity.Departement;
import com.example.springproject.Repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DepartementService implements IDepartementService {
    @Autowired
    private DepartementRepository myRepository;

  public int ajouterDepartement(Departement D) {
    myRepository.save(D);
    if (myRepository.findById((long) D.getIdDepart()).equals(D))
      return 1;
    else
      return 0;
  }

  public Boolean DeleteDepartement(Departement D) {
    myRepository.delete(D);
    return !myRepository.findById((long) D.getIdDepart()).equals(D);
  }

  public Boolean UpdateDepartement(Departement D) {
    myRepository.delete(D);
    return myRepository.findById((long) D.getIdDepart()).equals(D);
  }

  public List<Departement> findAll(Departement D) {
    return (List<Departement>) myRepository.findAll();
  }

  public Departement findById(Departement D) {
    return myRepository.findById((long) D.getIdDepart()).get();
  }
}
