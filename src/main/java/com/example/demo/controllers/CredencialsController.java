package com.example.demo.controllers;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.CredencialsRepository;
import com.example.demo.rest.CredencialsIdentity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/restaurant")
public class CredencialsController {

    @Autowired
    private CredencialsRepository credencialsRepository;

    //get address
    @GetMapping("address")
    public List<CredencialsIdentity> getAllAddress() {
        return this.credencialsRepository.findAll();
    }

    //get address by id
    @GetMapping("/address/{id}")
    public ResponseEntity<CredencialsIdentity> getAddressById(@PathVariable(value = "id") int id_credencials)
            throws ResourceNotFoundException {
        CredencialsIdentity credencialsIdentity = credencialsRepository.findById(id_credencials)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + id_credencials));
        return ResponseEntity.ok().body(credencialsIdentity);
    }

    //save address
    @PostMapping("address")
    public CredencialsIdentity createAddress(@RequestBody CredencialsIdentity credencialsIdentity) {
        return this.credencialsRepository.save(credencialsIdentity);
    }

    //update address
    @PutMapping("address/{id}")
    public ResponseEntity<CredencialsIdentity> updateAddress(@PathVariable(value = "id") int id_credencials,
                                                         @Validated @RequestBody CredencialsIdentity credencialsDetails) throws ResourceNotFoundException {

        CredencialsIdentity credencialsIdentity = credencialsRepository.findById(id_credencials)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + id_credencials));

        credencialsIdentity.setPassword(credencialsDetails.getPassword());
        credencialsIdentity.setToken(credencialsDetails.getToken());

        return ResponseEntity.ok(this.credencialsRepository.save(credencialsIdentity));

    }
    //delete address

    @DeleteMapping("address/{id}")
    public Map<String, Boolean> deleteAddress(@PathVariable(value = "id") int id_credencials) throws ResourceNotFoundException {

        CredencialsIdentity credencialsIdentity = credencialsRepository.findById(id_credencials)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + id_credencials));

        this.credencialsRepository.delete(credencialsIdentity);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
