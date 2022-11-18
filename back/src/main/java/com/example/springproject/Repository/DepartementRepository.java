package com.example.springproject.Repository;

import com.example.springproject.Entity.Departement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository extends CrudRepository<Departement,Long> {
}
