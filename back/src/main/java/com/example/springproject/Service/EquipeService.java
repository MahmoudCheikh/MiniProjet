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
  @Autowired
  private com.example.springproject.Repository.EquipeRepository EquipeRepository;

  @Override
  public int ajouterEquipe(Equipe C) {
    EquipeRepository.save(C);
    return 1;
  }

  @Override
  public Boolean deleteEquipe(Equipe C) {
    EquipeRepository.delete(C);
    return true;
  }


  @Override
  public Boolean updateEquipe(Equipe C) {
    EquipeRepository.save(C);
    return EquipeRepository.findById((Integer) C.getIdEquipe()).equals(C);
  }

  @Override
  public List<Equipe> findAll() {
    return (List<Equipe>) EquipeRepository.findAll();
  }

  @Override
  public Equipe findById(Integer U) {
    return EquipeRepository.findById(U).get();
  }
}
