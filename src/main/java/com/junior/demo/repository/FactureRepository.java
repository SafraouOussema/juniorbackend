package com.junior.demo.repository;


import com.junior.demo.entity.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "facture", collectionResourceRel = "facture") 
public interface FactureRepository  extends JpaRepository<Facture,Long>{
    
}
