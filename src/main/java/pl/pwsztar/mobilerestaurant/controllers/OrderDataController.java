package pl.pwsztar.mobilerestaurant.controllers;

import pl.pwsztar.mobilerestaurant.exceptions.ResourceNotFoundException;
import pl.pwsztar.mobilerestaurant.repositories.OrderDataRepository;
import pl.pwsztar.mobilerestaurant.model.OrderDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/restaurant")
public class OrderDataController {

    @Autowired
    private OrderDataRepository orderDataRepository;

    //get address
    @GetMapping("/order-data")
    public List<OrderDataDto> getAllAddress() {
        return this.orderDataRepository.findAll();
    }

    //get address by id
    @GetMapping("/order-data/{id}")
    public ResponseEntity<OrderDataDto> getAddressById(@PathVariable(value = "id") int id_zamowienia)
            throws ResourceNotFoundException {
        OrderDataDto orderDataDto = orderDataRepository.findById(id_zamowienia)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + id_zamowienia));
        return ResponseEntity.ok().body(orderDataDto);
    }

    //save address
    @PostMapping("order-data")
    public OrderDataDto createAddress(@RequestBody OrderDataDto orderDataDto) {
        return this.orderDataRepository.save(orderDataDto);
    }

    //update address
    @PutMapping("/order-data/{id}")
    public ResponseEntity<OrderDataDto> updateAddress(@RequestBody OrderDataDto orderData) throws ResourceNotFoundException {
        return ResponseEntity.ok(this.orderDataRepository.save(orderData));

    }

    //delete address
    @DeleteMapping("/order-data/{id}")
    public Map<String, Boolean> deleteAddress(@PathVariable(value = "id") int id_zamowienia) throws ResourceNotFoundException {

        OrderDataDto orderDataDto = orderDataRepository.findById(id_zamowienia)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + id_zamowienia));

        this.orderDataRepository.delete(orderDataDto);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
