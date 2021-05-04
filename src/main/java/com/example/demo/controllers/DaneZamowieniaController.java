package com.example.demo.controllers;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.DaneZamowieniaRepository;
import com.example.demo.rest.DaneZamowieniaIdentity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/restaurant")
public class DaneZamowieniaController {

    @Autowired
    private DaneZamowieniaRepository daneZamowieniaRepository;

    //get address
    @GetMapping("dane-zamowienia")
    public List<DaneZamowieniaIdentity> getAllAddress() {
        return this.daneZamowieniaRepository.findAll();
    }

    //get address by id
    @GetMapping("/dane-zamowienia/{id}")
    public ResponseEntity<DaneZamowieniaIdentity> getAddressById(@PathVariable(value = "id") int id_zamowienia)
            throws ResourceNotFoundException {
        DaneZamowieniaIdentity daneZamowieniaIdentity = daneZamowieniaRepository.findById(id_zamowienia)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + id_zamowienia));
        return ResponseEntity.ok().body(daneZamowieniaIdentity);
    }

    //save address
    @PostMapping("dane-zamowienia")
    public DaneZamowieniaIdentity createAddress(@RequestBody DaneZamowieniaIdentity daneZamowieniaIdentity) {
        return this.daneZamowieniaRepository.save(daneZamowieniaIdentity);
    }

    //update address
    @PutMapping("dane-zamowienia/{id}")
    public ResponseEntity<DaneZamowieniaIdentity> updateAddress(@PathVariable(value = "id") int id_zamowienia,
                                                         @Validated @RequestBody DaneZamowieniaIdentity daneZamowieniaDetails) throws ResourceNotFoundException {

        DaneZamowieniaIdentity daneZamowieniaIdentity = daneZamowieniaRepository.findById(id_zamowienia)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + id_zamowienia));

        daneZamowieniaIdentity.setId_dania(daneZamowieniaDetails.getId_dania());
        daneZamowieniaIdentity.setIlosc(daneZamowieniaDetails.getIlosc());

        return ResponseEntity.ok(this.daneZamowieniaRepository.save(daneZamowieniaIdentity));

    }
    //delete address

    @DeleteMapping("dane-zamowienia/{id}")
    public Map<String, Boolean> deleteAddress(@PathVariable(value = "id") int id_zamowienia) throws ResourceNotFoundException {

        DaneZamowieniaIdentity daneZamowieniaIdentity = daneZamowieniaRepository.findById(id_zamowienia)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + id_zamowienia));

        this.daneZamowieniaRepository.delete(daneZamowieniaIdentity);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
