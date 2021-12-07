package com.junior.demo.controller;

import java.util.List;
import java.util.Optional;

import com.junior.demo.entity.Produit;
import com.junior.demo.repository.ProduitRepository;
import com.junior.demo.service.ProduiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;  
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/application")
public class ProduitController {

    
    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private ProduiService produitService;

    @GetMapping("/produits")
    public ResponseEntity<List<Produit>> GetProduit() {
        List<Produit> allProduitList =  null;
        allProduitList = produitRepository.findAll();
        if (allProduitList.isEmpty())
            return ResponseEntity.noContent().build();

        return new ResponseEntity<>(allProduitList, HttpStatus.OK);
    }
    @GetMapping("/produit/{produitId}")
    public ResponseEntity<Optional<Produit>> getProduitById(@PathVariable long produitId) {
        Optional<Produit> produitList;
        produitList = produitService.getProduitById(produitId);

        if (!produitList.isPresent())
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(produitList, HttpStatus.OK);

    }
 

    @PostMapping("/produit")
    public ResponseEntity<Produit> addProduit(@RequestBody Produit company) {
        Produit produitLocal = null;
        produitLocal = produitRepository.save(company);

        if (produitLocal == null)
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(produitLocal, HttpStatus.OK);

    }


    @DeleteMapping("/produit/{produitId}")
    public ResponseEntity<Produit> deleteProduit(@PathVariable long produitId) {
        produitRepository.deleteById(produitId);
        return ResponseEntity.accepted().build();
    }

    
}
