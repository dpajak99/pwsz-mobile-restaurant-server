package pl.pwsztar.mobilerestaurant.controllers;

import pl.pwsztar.mobilerestaurant.exceptions.ResourceNotFoundException;
import pl.pwsztar.mobilerestaurant.repositories.AddressRepository;
import pl.pwsztar.mobilerestaurant.model.AddressDto;
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
    @GetMapping("/address")
    public List<AddressDto> getAllAddress() {
        return this.addressRepository.findAll();
    }

    //get address by id
    @GetMapping("/address/{id}")
    public ResponseEntity<AddressDto> getAddressById(@PathVariable(value = "id") int id_adresu)
        throws ResourceNotFoundException {
        AddressDto addressDto = addressRepository.findById(id_adresu)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + id_adresu));
        return ResponseEntity.ok().body(addressDto);
    }

    //get userAddress
    @GetMapping("/{userId}/address/")
    public ResponseEntity<AddressDto> getUserAddress(@PathVariable(value = "userId") int userId) {
        AddressDto addressDto = addressRepository.findByUserId(userId);
        return ResponseEntity.ok().body(addressDto);
    }

    //save address
    @PostMapping("/address")
    public AddressDto createAddress(@RequestBody AddressDto addressDto) {
        return this.addressRepository.save(addressDto);
    }

    //update address
    @PutMapping("/address/{id}")
    public ResponseEntity<AddressDto> updateAddress(@RequestBody AddressDto address) {
        return ResponseEntity.ok(this.addressRepository.save(address));
    }

    //delete address
    @DeleteMapping("/address/{id}")
    public Map<String, Boolean> deleteAddress(@PathVariable(value = "id") int addressId) throws ResourceNotFoundException {

        AddressDto addressDto = addressRepository.findById(addressId)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + addressId));

        this.addressRepository.delete(addressDto);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
