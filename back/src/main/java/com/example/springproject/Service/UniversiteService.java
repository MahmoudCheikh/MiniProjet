package com.example.springproject.Service;

import com.example.springproject.Entity.Universite;
import com.example.springproject.Entity.Equipe;
import com.example.springproject.Entity.Universite;
import com.example.springproject.Repository.UniversiteRepository;
import com.example.springproject.Repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UniversiteService implements IUniversiteService {
    @Autowired
    private UniversiteRepository UniversiteRepository;

  @Override
  public int ajouterUniversite(Universite C) {
    UniversiteRepository.save(C);
    return 1;
  }

  @Override
  public Boolean deleteUniversite(Universite C) {
    UniversiteRepository.delete(C);
    return true;
  }


  @Override
  public Boolean updateUniversite(Universite C) {
    UniversiteRepository.save(C);
    return  UniversiteRepository.findById((Integer) C.getIdUniv()).equals(C);
  }

  @Override
  public List<Universite> findAll() {
    return (List<Universite>) UniversiteRepository.findAll();
  }

  @Override
  public Universite findById(Integer U) {
    return UniversiteRepository.findById(U).get();
  }
}
