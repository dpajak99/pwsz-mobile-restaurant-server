package pl.pwsztar.mobilerestaurant.controllers;

import pl.pwsztar.mobilerestaurant.exceptions.ResourceNotFoundException;
import pl.pwsztar.mobilerestaurant.repositories.OrderRepository;
import pl.pwsztar.mobilerestaurant.model.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/restaurant")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    //get address
    @GetMapping("/order")
    public List<OrderDto> getAllAddress() {
        return this.orderRepository.findAll();
    }

    //get address by id
    @GetMapping("/order/{id}")
    public ResponseEntity<OrderDto> getAddressById(@PathVariable(value = "id") int orderId)
            throws ResourceNotFoundException {
        OrderDto orderDto = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + orderId));
        return ResponseEntity.ok().body(orderDto);
    }

    //save address
    @PostMapping("/order")
    public OrderDto createAddress(@RequestBody OrderDto orderDto) {
        return this.orderRepository.save(orderDto);
    }

    //update address
    @PutMapping("/order/{id}")
    public ResponseEntity<OrderDto> updateAddress(@RequestBody OrderDto order) {
        return ResponseEntity.ok(this.orderRepository.save(order));

    }
    //delete address

    @DeleteMapping("/order/{id}")
    public Map<String, Boolean> deleteAddress(@PathVariable(value = "id") int orderId) throws ResourceNotFoundException {

        OrderDto orderDto = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + orderId));

        this.orderRepository.delete(orderDto);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
