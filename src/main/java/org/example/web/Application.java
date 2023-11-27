package org.example.web;


import org.example.entities.Compte;
import org.example.entities.EtatCompte;
import org.example.entities.TypeCompte;

import org.example.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Application {


    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
    @Bean
    CommandLineRunner demo (CompteRepository compteRepository) {
        return (args) -> {
            // Ajout des Comptes
            Compte compteEpargne1 = new Compte(135L, 1000.0, new Date(), TypeCompte.EPARGNE, EtatCompte.CREE);
            Compte compteEpargne2 = new Compte(975L, 1500.0, new Date(), TypeCompte.EPARGNE, EtatCompte.CREE);
            Compte compteCourant = new Compte(246L, 500.0, new Date(), TypeCompte.COURANT, EtatCompte.CREE);

            compteRepository.save(compteCourant);
            compteRepository.save(compteEpargne1);
            compteRepository.save(compteEpargne2);

            // Afficahge les soldes des comptes
            System.out.println("Soldes des comptes :");
            List<Compte> comptes = compteRepository.findAll();
            for (Compte compte : comptes) {
                System.out.println("Le compte avec l'ID :" + compte.getId() + " ,Solde =" + compte.getSolde());
            }
        };
    }
}