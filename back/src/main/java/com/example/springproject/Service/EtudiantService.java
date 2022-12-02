package com.example.springproject.Service;

import com.example.springproject.Entity.Contrat;
import com.example.springproject.Entity.Equipe;
import com.example.springproject.Entity.Etudiant;
import com.example.springproject.Entity.Etudiant;
import com.example.springproject.Repository.ContratRepository;
import com.example.springproject.Repository.EtudiantRepository;
import com.example.springproject.Repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service

public class EtudiantService implements IEtudiantService {
    @Autowired
    private EtudiantRepository EtudiantRepository;
    private ContratRepository ContratRepository;

  @Override
  public int ajouterEtudiant(Etudiant C) {
    EtudiantRepository.save(C);
    return 1;
  }

  @Override
  public Boolean deleteEtudiant(Etudiant C) {
    EtudiantRepository.delete(C);
    return true;
  }


  @Override
  public Boolean updateEtudiant(Etudiant C) {
    EtudiantRepository.save(C);
    return  EtudiantRepository.findById((Integer) C.getIdEtudaint()).equals(C);
  }

  @Override
  public List<Etudiant> findAll() {
    return (List<Etudiant>) EtudiantRepository.findAll();
  }

  @Override
  public Etudiant findById(Integer U) {
    return EtudiantRepository.findById(U).get();
  }


  public Contrat affectContratToEtudiant(Contrat c, String nom, String prenom) {
    Etudiant e=EtudiantRepository.findOneByNomEAndPrenomE(nom,prenom);

    e.getContratList().add(c);
    c.setEtudiant(e);
    ContratRepository.save(c);
    EtudiantRepository.save(e);
    return c;
  }

}
