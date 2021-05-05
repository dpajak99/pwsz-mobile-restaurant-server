package pl.pwsztar.mobilerestaurant.controllers;

import pl.pwsztar.mobilerestaurant.exceptions.ResourceNotFoundException;
import pl.pwsztar.mobilerestaurant.repositories.FoodRepository;
import pl.pwsztar.mobilerestaurant.model.FoodDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/restaurant")
public class FoodController {

    @Autowired
    private FoodRepository foodRepository;

    //get address
    @GetMapping("danie")
    public List<FoodDto> getAllAddress() {
        return this.foodRepository.findAll();
    }

    //get address by id
    @GetMapping("/danie/{id}")
    public ResponseEntity<FoodDto> getAddressById(@PathVariable(value = "id") int id_dania)
            throws ResourceNotFoundException {
        FoodDto foodDto = foodRepository.findById(id_dania)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + id_dania));
        return ResponseEntity.ok().body(foodDto);
    }

    //save address
    @PostMapping("danie")
    public FoodDto createAddress(@RequestBody FoodDto foodDto) {
        return this.foodRepository.save(foodDto);
    }

    //update address
    @PutMapping("danie/{id}")
    public ResponseEntity<FoodDto> updateAddress(@RequestBody FoodDto danieDetails) {

        return ResponseEntity.ok(this.foodRepository.save(danieDetails));

    }
    //delete address

    @DeleteMapping("danie/{id}")
    public Map<String, Boolean> deleteAddress(@PathVariable(value = "id") int id_dania) throws ResourceNotFoundException {

        FoodDto foodDto = foodRepository.findById(id_dania)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + id_dania));

        this.foodRepository.delete(foodDto);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
