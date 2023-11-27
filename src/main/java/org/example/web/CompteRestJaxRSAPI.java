package org.example.web;


import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.entities.Compte;
import org.example.repositories.CompteRepository;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Path("/banque")
public class CompteRestJaxRSAPI {

    private CompteRepository compteRepository;
    @Path("/comptes")
    @GET @Transactional
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Compte> compteList(){
        return compteRepository.findAll();
    }
    @Path("/comptes/{id}")
    @POST @Produces({MediaType.APPLICATION_JSON})
    public Compte getOne(@PathParam("id") Long id){
        return compteRepository.findById(id).get();
    }

    @Path("/comptes")
    @POST @Produces({MediaType.APPLICATION_JSON})
    public Compte save(Compte compte){
        return compteRepository.save(compte);
    }

    @Path("/comptes/{id}")
    @POST @Produces({MediaType.APPLICATION_JSON})
    public Compte update(Compte compte, @PathParam("id") Long id){
        compte.setId(id);
        return compteRepository.save(compte);
    }

    @Path("/comptes/{id}")
    @DELETE @Produces({MediaType.APPLICATION_JSON})
    public void delete(@PathParam("id") Long id){
        compteRepository.deleteById(id);
        System.out.println("Compte est supprimé");
    }
}
