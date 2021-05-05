package pl.pwsztar.mobilerestaurant.controllers;

import pl.pwsztar.mobilerestaurant.exceptions.ResourceNotFoundException;
import pl.pwsztar.mobilerestaurant.repositories.PaymentRepository;
import pl.pwsztar.mobilerestaurant.model.PaymentDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/restaurant")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    //get address
    @GetMapping("payment")
    public List<PaymentDataDto> getAllAddress() {
        return this.paymentRepository.findAll();
    }

    //get address by id
    @GetMapping("/payment/{id}")
    public ResponseEntity<PaymentDataDto> getAddressById(@PathVariable(value = "id") int paymentId)
            throws ResourceNotFoundException {
        PaymentDataDto platnoscIdentity = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + paymentId));
        return ResponseEntity.ok().body(platnoscIdentity);
    }

    //save address
    @PostMapping("payment")
    public PaymentDataDto createAddress(@RequestBody PaymentDataDto platnoscIdentity) {
        return this.paymentRepository.save(platnoscIdentity);
    }

    //update address
    @PutMapping("platnosc/{id}")
    public ResponseEntity<PaymentDataDto> updateAddress(@RequestBody PaymentDataDto payment) {

        return ResponseEntity.ok(this.paymentRepository.save(payment));

    }
    //delete address

    @DeleteMapping("platnosc/{id}")
    public Map<String, Boolean> deleteAddress(@PathVariable(value = "id") int paymentId) throws ResourceNotFoundException {

        PaymentDataDto platnoscIdentity = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + paymentId));

        this.paymentRepository.delete(platnoscIdentity);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
