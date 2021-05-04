package com.example.demo.controllers;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.PracownikRepository;
import com.example.demo.rest.PracownikIdentity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/restaurant")
public class PracownikController {

    @Autowired
    private PracownikRepository pracownikRepository;

    //get address
    @GetMapping("pracownik")
    public List<PracownikIdentity> getAllAddress() {
        return this.pracownikRepository.findAll();
    }

    //get address by id
    @GetMapping("/pracownik/{id}")
    public ResponseEntity<PracownikIdentity> getAddressById(@PathVariable(value = "id") int id_pracownika)
            throws ResourceNotFoundException {
        PracownikIdentity pracownikIdentity = pracownikRepository.findById(id_pracownika)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + id_pracownika));
        return ResponseEntity.ok().body(pracownikIdentity);
    }

    //save address
    @PostMapping("pracownik")
    public PracownikIdentity createAddress(@RequestBody PracownikIdentity pracownikIdentity) {
        return this.pracownikRepository.save(pracownikIdentity);
    }

    //update address
    @PutMapping("pracownik/{id}")
    public ResponseEntity<PracownikIdentity> updateAddress(@PathVariable(value = "id") int id_pracownika,
                                                        @Validated @RequestBody PracownikIdentity pracownikDetails) throws ResourceNotFoundException {

        PracownikIdentity pracownikIdentity = pracownikRepository.findById(id_pracownika)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + id_pracownika));

        pracownikIdentity.setImie(pracownikDetails.getImie());
        pracownikIdentity.setNazwisko(pracownikDetails.getNazwisko());

        return ResponseEntity.ok(this.pracownikRepository.save(pracownikIdentity));

    }
    //delete address

    @DeleteMapping("pracownik/{id}")
    public Map<String, Boolean> deleteAddress(@PathVariable(value = "id") int id_pracownika) throws ResourceNotFoundException {

        PracownikIdentity pracownikIdentity = pracownikRepository.findById(id_pracownika)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + id_pracownika));

        this.pracownikRepository.delete(pracownikIdentity);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
