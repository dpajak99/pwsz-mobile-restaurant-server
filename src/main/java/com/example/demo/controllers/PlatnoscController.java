package com.example.demo.controllers;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.DaneZamowieniaRepository;
import com.example.demo.repositories.PlatnoscRepository;
import com.example.demo.rest.DaneZamowieniaIdentity;
import com.example.demo.rest.PlatnoscIdentity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/restaurant")
public class PlatnoscController {

    @Autowired
    private PlatnoscRepository platnoscRepository;

    //get address
    @GetMapping("platnosc")
    public List<PlatnoscIdentity> getAllAddress() {
        return this.platnoscRepository.findAll();
    }

    //get address by id
    @GetMapping("/platnosc/{id}")
    public ResponseEntity<PlatnoscIdentity> getAddressById(@PathVariable(value = "id") int id_platnosci)
            throws ResourceNotFoundException {
        PlatnoscIdentity platnoscIdentity = platnoscRepository.findById(id_platnosci)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + id_platnosci));
        return ResponseEntity.ok().body(platnoscIdentity);
    }

    //save address
    @PostMapping("platnosc")
    public PlatnoscIdentity createAddress(@RequestBody PlatnoscIdentity platnoscIdentity) {
        return this.platnoscRepository.save(platnoscIdentity);
    }

    //update address
    @PutMapping("platnosc/{id}")
    public ResponseEntity<PlatnoscIdentity> updateAddress(@PathVariable(value = "id") int id_platnosci,
                                                                @Validated @RequestBody PlatnoscIdentity platnoscDetails) throws ResourceNotFoundException {

        PlatnoscIdentity platnoscIdentity = platnoscRepository.findById(id_platnosci)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + id_platnosci));

        platnoscIdentity.setKwota_platnosci(platnoscDetails.getKwota_platnosci());
        platnoscIdentity.setMetoda_platnosci(platnoscDetails.getMetoda_platnosci());
        platnoscIdentity.setData_oplacenia(platnoscDetails.getData_oplacenia());
        platnoscIdentity.setData_start(platnoscDetails.getData_start());

        return ResponseEntity.ok(this.platnoscRepository.save(platnoscIdentity));

    }
    //delete address

    @DeleteMapping("platnosc/{id}")
    public Map<String, Boolean> deleteAddress(@PathVariable(value = "id") int id_platnosci) throws ResourceNotFoundException {

        PlatnoscIdentity platnoscIdentity = platnoscRepository.findById(id_platnosci)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + id_platnosci));

        this.platnoscRepository.delete(platnoscIdentity);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
