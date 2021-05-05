package pl.pwsztar.mobilerestaurant.controllers;

import pl.pwsztar.mobilerestaurant.exceptions.ResourceNotFoundException;
import pl.pwsztar.mobilerestaurant.repositories.ClientRepository;
import pl.pwsztar.mobilerestaurant.model.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/restaurant")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    //get address
    @GetMapping("klient")
    public List<ClientDto> getAllAddress() {
        return this.clientRepository.findAll();
    }

    //get address by id
    @GetMapping("/klient/{id}")
    public ResponseEntity<ClientDto> getAddressById(@PathVariable(value = "id") int clientId)
            throws ResourceNotFoundException {
        ClientDto clientDto = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + clientId));
        return ResponseEntity.ok().body(clientDto);
    }

    //save address
    @PostMapping("klient")
    public ClientDto createAddress(@RequestBody ClientDto clientDto) {
        return this.clientRepository.save(clientDto);
    }

    //update address
    @PutMapping("klient/{id}")
    public ResponseEntity<ClientDto> updateAddress(@RequestBody ClientDto client) {

        return ResponseEntity.ok(this.clientRepository.save(client));

    }
    //delete address

    @DeleteMapping("klient/{id}")
    public Map<String, Boolean> deleteAddress(@PathVariable(value = "id") int clientId) throws ResourceNotFoundException {

        ClientDto clientDto = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + clientId));

        this.clientRepository.delete(clientDto);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
