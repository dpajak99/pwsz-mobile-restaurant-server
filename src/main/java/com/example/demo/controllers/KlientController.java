package com.example.demo.controllers;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.KlientRepository;
import com.example.demo.rest.KlientIdentity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/restaurant")
public class KlientController {

    @Autowired
    private KlientRepository klientRepository;

    //get address
    @GetMapping("klient")
    public List<KlientIdentity> getAllAddress() {
        return this.klientRepository.findAll();
    }

    //get address by id
    @GetMapping("/klient/{id}")
    public ResponseEntity<KlientIdentity> getAddressById(@PathVariable(value = "id") int id_klienta)
            throws ResourceNotFoundException {
        KlientIdentity klientIdentity = klientRepository.findById(id_klienta)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + id_klienta));
        return ResponseEntity.ok().body(klientIdentity);
    }

    //save address
    @PostMapping("klient")
    public KlientIdentity createAddress(@RequestBody KlientIdentity klientIdentity) {
        return this.klientRepository.save(klientIdentity);
    }

    //update address
    @PutMapping("klient/{id}")
    public ResponseEntity<KlientIdentity> updateAddress(@PathVariable(value = "id") int id_klienta,
                                                           @Validated @RequestBody KlientIdentity klientDetails) throws ResourceNotFoundException {

        KlientIdentity klientIdentity = klientRepository.findById(id_klienta)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + id_klienta));

        klientIdentity.setId_adresu(klientDetails.getId_adresu());
        klientIdentity.setId_credencials(klientDetails.getId_credencials());
        klientIdentity.setImie(klientDetails.getImie());
        klientIdentity.setNazwisko(klientDetails.getNazwisko());
        klientIdentity.setTelefon_komorkowy(klientDetails.getTelefon_komorkowy());
        klientIdentity.setAdres_email(klientDetails.getAdres_email());

        return ResponseEntity.ok(this.klientRepository.save(klientIdentity));

    }
    //delete address

    @DeleteMapping("klient/{id}")
    public Map<String, Boolean> deleteAddress(@PathVariable(value = "id") int id_klienta) throws ResourceNotFoundException {

        KlientIdentity klientIdentity = klientRepository.findById(id_klienta)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + id_klienta));

        this.klientRepository.delete(klientIdentity);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
