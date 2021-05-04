package com.example.demo.controllers;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.DanieRepository;
import com.example.demo.rest.DanieIdentity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/restaurant")
public class DanieController {

    @Autowired
    private DanieRepository danieRepository;

    //get address
    @GetMapping("danie")
    public List<DanieIdentity> getAllAddress() {
        return this.danieRepository.findAll();
    }

    //get address by id
    @GetMapping("/danie/{id}")
    public ResponseEntity<DanieIdentity> getAddressById(@PathVariable(value = "id") int id_dania)
            throws ResourceNotFoundException {
        DanieIdentity danieIdentity = danieRepository.findById(id_dania)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + id_dania));
        return ResponseEntity.ok().body(danieIdentity);
    }

    //save address
    @PostMapping("danie")
    public DanieIdentity createAddress(@RequestBody DanieIdentity danieIdentity) {
        return this.danieRepository.save(danieIdentity);
    }

    //update address
    @PutMapping("danie/{id}")
    public ResponseEntity<DanieIdentity> updateAddress(@PathVariable(value = "id") int id_dania,
                                                                @Validated @RequestBody DanieIdentity danieDetails) throws ResourceNotFoundException {

        DanieIdentity danieIdentity = danieRepository.findById(id_dania)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + id_dania));

        danieIdentity.setId_kategorii(danieDetails.getId_kategorii());
        danieIdentity.setCena(danieDetails.getCena());
        danieIdentity.setNazwa(danieDetails.getNazwa());
        danieIdentity.setOpis(danieDetails.getOpis());

        return ResponseEntity.ok(this.danieRepository.save(danieIdentity));

    }
    //delete address

    @DeleteMapping("danie/{id}")
    public Map<String, Boolean> deleteAddress(@PathVariable(value = "id") int id_dania) throws ResourceNotFoundException {

        DanieIdentity danieIdentity = danieRepository.findById(id_dania)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + id_dania));

        this.danieRepository.delete(danieIdentity);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
