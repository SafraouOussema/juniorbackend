package com.junior.demo.repository;


import java.util.List;
import java.util.Optional;

import com.junior.demo.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "produit", collectionResourceRel = "produit")
public interface ProduitRepository extends JpaRepository<Produit,Long> {
    
    public List<Produit> findProduitByDelivery(Long company);

} 
