package com.example.demo.controllers;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.OcenaZamowieniaRepository;
import com.example.demo.rest.OcenaZamowieniaIdentity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/restaurant")
public class OcenaZamowieniaController {

    @Autowired
    private OcenaZamowieniaRepository ocenaZamowieniaRepository;

    //get address
    @GetMapping("ocena-zamowienia")
    public List<OcenaZamowieniaIdentity> getAllAddress() {
        return this.ocenaZamowieniaRepository.findAll();
    }

    //get address by id
    @GetMapping("/ocena-zamowienia/{id}")
    public ResponseEntity<OcenaZamowieniaIdentity> getAddressById(@PathVariable(value = "id") int id_oceny_zamowienia)
            throws ResourceNotFoundException {
        OcenaZamowieniaIdentity ocenaZamowieniaIdentity = ocenaZamowieniaRepository.findById(id_oceny_zamowienia)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + id_oceny_zamowienia));
        return ResponseEntity.ok().body(ocenaZamowieniaIdentity);
    }

    //save address
    @PostMapping("ocena-zamowienia")
    public OcenaZamowieniaIdentity createAddress(@RequestBody OcenaZamowieniaIdentity ocenaZamowieniaIdentity) {
        return this.ocenaZamowieniaRepository.save(ocenaZamowieniaIdentity);
    }

    //update address
    @PutMapping("ocena-zamowienia/{id}")
    public ResponseEntity<OcenaZamowieniaIdentity> updateAddress(@PathVariable(value = "id") int id_oceny_zamowienia,
                                                        @Validated @RequestBody OcenaZamowieniaIdentity ocenaZamowieniaDetails) throws ResourceNotFoundException {

        OcenaZamowieniaIdentity ocenaZamowieniaIdentity = ocenaZamowieniaRepository.findById(id_oceny_zamowienia)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + id_oceny_zamowienia));

        ocenaZamowieniaIdentity.setSkala(ocenaZamowieniaDetails.getSkala());
        ocenaZamowieniaIdentity.setUwagi(ocenaZamowieniaDetails.getUwagi());

        return ResponseEntity.ok(this.ocenaZamowieniaRepository.save(ocenaZamowieniaIdentity));

    }
    //delete address

    @DeleteMapping("ocena-zamowienia/{id}")
    public Map<String, Boolean> deleteAddress(@PathVariable(value = "id") int id_oceny_zamowienia) throws ResourceNotFoundException {

        OcenaZamowieniaIdentity ocenaZamowieniaIdentity = ocenaZamowieniaRepository.findById(id_oceny_zamowienia)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + id_oceny_zamowienia));

        this.ocenaZamowieniaRepository.delete(ocenaZamowieniaIdentity);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
