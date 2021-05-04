package com.example.demo.controllers;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.KategoriaRepository;
import com.example.demo.rest.AddressIdentity;
import com.example.demo.rest.KategoriaIdentity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/restaurant")
public class KategoriaController {

    @Autowired
    private KategoriaRepository kategoriaRepository;

    //get address
    @GetMapping("kategoria")
    public List<KategoriaIdentity> getAllAddress() {
        return this.kategoriaRepository.findAll();
    }

    //get address by id
    @GetMapping("/kategoria/{id}")
    public ResponseEntity<KategoriaIdentity> getAddressById(@PathVariable(value = "id") int id_kategorii)
            throws ResourceNotFoundException {
        KategoriaIdentity kategoriaIdentity = kategoriaRepository.findById(id_kategorii)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + id_kategorii));
        return ResponseEntity.ok().body(kategoriaIdentity);
    }

    //save address
    @PostMapping("kategoria")
    public KategoriaIdentity createAddress(@RequestBody KategoriaIdentity kategoriaIdentity) {
        return this.kategoriaRepository.save(kategoriaIdentity);
    }

    //update address
    @PutMapping("kategoria/{id}")
    public ResponseEntity<KategoriaIdentity> updateAddress(@PathVariable(value = "id") int id_kategorii,
                                                         @Validated @RequestBody KategoriaIdentity kategoriaDetails) throws ResourceNotFoundException {

        KategoriaIdentity kategoriaIdentity = kategoriaRepository.findById(id_kategorii)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + id_kategorii));

        kategoriaIdentity.setNazwa(kategoriaDetails.getNazwa());
        kategoriaIdentity.setOpis(kategoriaDetails.getOpis());

        return ResponseEntity.ok(this.kategoriaRepository.save(kategoriaIdentity));

    }
    //delete address

    @DeleteMapping("kategoria/{id}")
    public Map<String, Boolean> deleteAddress(@PathVariable(value = "id") int id_kategorii) throws ResourceNotFoundException {

        KategoriaIdentity kategoriaIdentity = kategoriaRepository.findById(id_kategorii)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + id_kategorii));

        this.kategoriaRepository.delete(kategoriaIdentity);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
