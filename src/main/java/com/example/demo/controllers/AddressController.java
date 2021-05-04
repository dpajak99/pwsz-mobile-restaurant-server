package com.example.demo.controllers;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.AddressRepository;
import com.example.demo.rest.AddressIdentity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/restaurant")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    //get address
    @GetMapping("address")
    public List<AddressIdentity> getAllAddress() {
        return this.addressRepository.findAll();
    }

    //get address by id
    @GetMapping("/address/{id}")
    public ResponseEntity<AddressIdentity> getAddressById(@PathVariable(value = "id") int id_adresu)
        throws ResourceNotFoundException {
        AddressIdentity addressIdentity = addressRepository.findById(id_adresu)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + id_adresu));
        return ResponseEntity.ok().body(addressIdentity);
    }

    //save address
    @PostMapping("address")
    public AddressIdentity createAddress(@RequestBody AddressIdentity addressIdentity) {
        return this.addressRepository.save(addressIdentity);
    }

    //update address
    @PutMapping("address/{id}")
    public ResponseEntity<AddressIdentity> updateAddress(@PathVariable(value = "id") int id_adresu,
                                                         @Validated @RequestBody AddressIdentity addressDetails) throws ResourceNotFoundException {

        AddressIdentity addressIdentity = addressRepository.findById(id_adresu)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + id_adresu));

        addressIdentity.setKod_pocztowy(addressDetails.getKod_pocztowy());
        addressIdentity.setMiasto(addressDetails.getMiasto());
        addressIdentity.setUlica(addressDetails.getUlica());
        addressIdentity.setNumer_mieszkania(addressDetails.getNumer_mieszkania());

        return ResponseEntity.ok(this.addressRepository.save(addressIdentity));

    }
    //delete address

    @DeleteMapping("address/{id}")
    public Map<String, Boolean> deleteAddress(@PathVariable(value = "id") int id_adresu) throws ResourceNotFoundException {

        AddressIdentity addressIdentity = addressRepository.findById(id_adresu)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + id_adresu));

        this.addressRepository.delete(addressIdentity);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
