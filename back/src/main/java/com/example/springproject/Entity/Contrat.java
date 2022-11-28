package com.example.springproject.Entity;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Contrat")
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_contrat")
    private Integer idContrat;
    private Date dateDebutContrat;
    private Date dateFinContrat;
    private Specialite specialite;
    private Boolean archive;

    @ManyToOne()
    Etudiant etudiant;

    @OneToMany(mappedBy = "contrat",fetch = FetchType.EAGER)
    private List<Paiement> paiementList;
}
