package com.example.springproject.Entity;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_equipe")
    private Integer idEquipe;
    private String nomEquipe;
    private Niveau niveau;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "equipes")
    private Set<Etudiant> etudiants;

    @OneToOne
    private DetailEquipe detailEquipe;
}
