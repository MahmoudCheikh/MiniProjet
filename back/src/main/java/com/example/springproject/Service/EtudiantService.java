package com.example.springproject.Service;

import com.example.springproject.Entity.Etudiant;
import com.example.springproject.Repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EtudiantService implements IEtudiantService {
    @Autowired
    private EtudiantRepository myRepository;

  public int ajouterEtudiant(Etudiant E) {
    myRepository.save(E);
    if (myRepository.findById((long) E.getIdEtudaint()).equals(E))
      return 1;
    else
      return 0;
  }

  public Boolean DeleteEtudiant(Etudiant E) {
    myRepository.delete(E);
    return !myRepository.findById((long) E.getIdEtudaint()).equals(E);
  }

  public Boolean UpdateEtudiant(Etudiant E) {
    myRepository.delete(E);
    return myRepository.findById((long) E.getIdEtudaint()).equals(E);
  }

  public List<Etudiant> findAll(Etudiant E) {
    return (List<Etudiant>) myRepository.findAll();
  }

  public Etudiant findById(Etudiant E) {
    return myRepository.findById((long) E.getIdEtudaint()).get();
  }
}
