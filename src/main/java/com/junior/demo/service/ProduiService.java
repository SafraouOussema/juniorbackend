package com.junior.demo.service;

import java.util.List;
import java.util.Optional;

import com.junior.demo.entity.Produit;
import com.junior.demo.repository.ProduitRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProduiService {

    @Autowired
    private ProduitRepository produitRepository;

    public Produit addScanedCode(Produit produit) {

        return produitRepository.save(produit);
    }

    public List<Produit> getAllScanedCode() {
        return produitRepository.findAll();
    }

    public Optional<Produit> getProduitById(Long id) {
        return produitRepository.findById(id);
    }

    public List<Produit> getProduitByDelivery(Long id) {
        return produitRepository.findProduitByDelivery(id);
    }
}
