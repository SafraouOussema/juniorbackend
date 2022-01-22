package com.junior.demo.controller;

import java.util.List;
import java.util.Optional;

import com.junior.demo.entity.Facture;
import com.junior.demo.repository.FactureRepository;
import com.junior.demo.service.FactureService;

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
public class FactureController {
    
    @Autowired
    private FactureRepository factureRepository;

    @Autowired
    private FactureService factureService;

    @GetMapping("/facture")
    public ResponseEntity<List<Facture>> GetFacture () {
        List<Facture> allFactureList =  null;
        allFactureList = factureRepository.findAll();
        if (allFactureList.isEmpty())
            return ResponseEntity.noContent().build();

        return new ResponseEntity<>(allFactureList, HttpStatus.OK);
    }

    @GetMapping("/facture/{factureId}")
    public ResponseEntity<Optional<Facture>> getFactureById(@PathVariable long factureId) {
        Optional<Facture> factureList;
        factureList = factureService.getFactureById(factureId);

        if (!factureList.isPresent())
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(factureList, HttpStatus.OK);

    }
 

    @PostMapping("/facture")
    public ResponseEntity<Facture> addFacture(@RequestBody Facture facture) {
        Facture factureInfo = null;
        factureInfo = factureRepository.save(facture);

        if (factureInfo == null)
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(factureInfo, HttpStatus.OK);

    }


    @DeleteMapping("/facture/{factureId}")
    public ResponseEntity<Facture> deleteFacture(@PathVariable long factureId) {
        factureRepository.deleteById(factureId);
        return ResponseEntity.accepted().build();
    }
}
