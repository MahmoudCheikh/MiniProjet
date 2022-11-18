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
@Table(name = "Departement")
@NoArgsConstructor
@AllArgsConstructor
public class Departement {
        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        private int idDepart;
        private String  nomDepart;


        @ManyToOne()
        Universite universite;

        @OneToMany(mappedBy = "departement")
        private List<Etudiant> etudiantList;
}
