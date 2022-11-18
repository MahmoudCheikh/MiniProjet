package com.example.springproject.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "Etudiant")
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_etudaint")
    private Integer idEtudaint;
    private Option  option;
    private String  prenomE;
    private String  nomE;

    @ManyToOne()
    Departement departement;

    @OneToMany(mappedBy = "etudiant")
    private List<Contrat> contratList;

}
