package org.example.entities;

import lombok.*;
import jakarta.persistence.*;

import java.util.Date;

@Getter@Setter@NoArgsConstructor@AllArgsConstructor@ToString
@Entity@Table
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private double solde;
    @Column
    private Date dateCreation;
    @Column
    private TypeCompte type;
    @Column
    private EtatCompte etat;

}
