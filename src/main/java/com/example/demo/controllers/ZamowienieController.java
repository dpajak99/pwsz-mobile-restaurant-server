package com.example.demo.controllers;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.ZamowienieRepository;
import com.example.demo.rest.ZamowienieIdentity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/restaurant")
public class ZamowienieController {

    @Autowired
    private ZamowienieRepository zamowienieRepository;

    //get address
    @GetMapping("dane-zamowienia")
    public List<ZamowienieIdentity> getAllAddress() {
        return this.zamowienieRepository.findAll();
    }

    //get address by id
    @GetMapping("/dane-zamowienia/{id}")
    public ResponseEntity<ZamowienieIdentity> getAddressById(@PathVariable(value = "id") int id_zamowienia)
            throws ResourceNotFoundException {
        ZamowienieIdentity zamowienieIdentity = zamowienieRepository.findById(id_zamowienia)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + id_zamowienia));
        return ResponseEntity.ok().body(zamowienieIdentity);
    }

    //save address
    @PostMapping("dane-zamowienia")
    public ZamowienieIdentity createAddress(@RequestBody ZamowienieIdentity zamowienieIdentity) {
        return this.zamowienieRepository.save(zamowienieIdentity);
    }

    //update address
    @PutMapping("dane-zamowienia/{id}")
    public ResponseEntity<ZamowienieIdentity> updateAddress(@PathVariable(value = "id") int id_zamowienia,
                                                                @Validated @RequestBody ZamowienieIdentity zamowienieDetails) throws ResourceNotFoundException {

        ZamowienieIdentity zamowienieIdentity = zamowienieRepository.findById(id_zamowienia)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + id_zamowienia));

        zamowienieIdentity.setId_pracownika(zamowienieDetails.getId_pracownika());
        zamowienieIdentity.setId_oceny_zamowienia(zamowienieDetails.getId_oceny_zamowienia());
        zamowienieIdentity.setId_klienta(zamowienieDetails.getId_klienta());
        zamowienieIdentity.setId_platnosci(zamowienieDetails.getId_platnosci());
        zamowienieIdentity.setUwagi_dod(zamowienieDetails.getUwagi_dod());
        zamowienieIdentity.setRealizacja_status(zamowienieDetails.getRealizacja_status());


        return ResponseEntity.ok(this.zamowienieRepository.save(zamowienieIdentity));

    }
    //delete address

    @DeleteMapping("dane-zamowienia/{id}")
    public Map<String, Boolean> deleteAddress(@PathVariable(value = "id") int id_zamowienia) throws ResourceNotFoundException {

        ZamowienieIdentity zamowienieIdentity = zamowienieRepository.findById(id_zamowienia)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + id_zamowienia));

        this.zamowienieRepository.delete(zamowienieIdentity);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
