package com.junior.demo.service;


import java.util.List;
import java.util.Optional;

import com.junior.demo.entity.Facture;
import com.junior.demo.repository.FactureRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FactureService {

    @Autowired
    private FactureRepository factureRepository;

    public Facture addFacture(Facture facture) {

        return factureRepository.save(facture);
    }

    public List<Facture> getAllFacture() {
        return factureRepository.findAll();
    }
 
    public Optional<Facture> getFactureById(Long id) {
        return factureRepository.findById(id);
    }
    
}
