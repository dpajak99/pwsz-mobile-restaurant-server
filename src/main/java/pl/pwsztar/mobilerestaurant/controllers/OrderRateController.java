package pl.pwsztar.mobilerestaurant.controllers;

import pl.pwsztar.mobilerestaurant.exceptions.ResourceNotFoundException;
import pl.pwsztar.mobilerestaurant.repositories.OrderRateRepository;
import pl.pwsztar.mobilerestaurant.model.OrderRateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/restaurant")
public class OrderRateController {

    @Autowired
    private OrderRateRepository orderRateRepository;

    //get address
    @GetMapping("/order-rate")
    public List<OrderRateDto> getAllAddress() {
        return this.orderRateRepository.findAll();
    }

    //get address by id
    @GetMapping("/order-rate/{id}")
    public ResponseEntity<OrderRateDto> getAddressById(@PathVariable(value = "id") int orderRateId)
            throws ResourceNotFoundException {
        OrderRateDto orderRateDto = orderRateRepository.findById(orderRateId)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + orderRateId));
        return ResponseEntity.ok().body(orderRateDto);
    }

    //save address
    @PostMapping("/order-rate")
    public OrderRateDto createAddress(@RequestBody OrderRateDto orderRateDto) {
        return this.orderRateRepository.save(orderRateDto);
    }

    //update address
    @PutMapping("/order-rate/{id}")
    public ResponseEntity<OrderRateDto> updateAddress(@RequestBody OrderRateDto orderRate) throws ResourceNotFoundException {
        return ResponseEntity.ok(this.orderRateRepository.save(orderRate));

    }
    //delete address

    @DeleteMapping("/order-rate/{id}")
    public Map<String, Boolean> deleteAddress(@PathVariable(value = "id") int orderRateId) throws ResourceNotFoundException {

        OrderRateDto orderRateDto = orderRateRepository.findById(orderRateId)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + orderRateId));

        this.orderRateRepository.delete(orderRateDto);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
