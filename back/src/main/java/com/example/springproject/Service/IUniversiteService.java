package com.example.springproject.Service;

import com.example.springproject.Entity.Universite;

import java.util.List;

public interface IUniversiteService {
    int ajouterUniversite(Universite C);

    Boolean deleteUniversite(Universite C);

    Boolean updateUniversite(Universite C);

    List<Universite> findAll();

    Universite findById(Integer C);
}
