package com.example.springproject.Repository;

import com.example.springproject.Entity.Universite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversiteRepository extends CrudRepository<Universite,Long> {
}
