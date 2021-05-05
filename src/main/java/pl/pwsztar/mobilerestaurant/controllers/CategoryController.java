package pl.pwsztar.mobilerestaurant.controllers;

import pl.pwsztar.mobilerestaurant.exceptions.ResourceNotFoundException;
import pl.pwsztar.mobilerestaurant.repositories.CategoryRepository;
import pl.pwsztar.mobilerestaurant.model.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/restaurant")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    //get address
    @GetMapping("kategoria")
    public List<CategoryDto> getAllAddress() {
        return this.categoryRepository.findAll();
    }

    //get address by id
    @GetMapping("/kategoria/{id}")
    public ResponseEntity<CategoryDto> getAddressById(@PathVariable(value = "id") int categoryId)
            throws ResourceNotFoundException {
        CategoryDto categoryDto = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + categoryId));
        return ResponseEntity.ok().body(categoryDto);
    }

    //save address
    @PostMapping("kategoria")
    public CategoryDto createAddress(@RequestBody CategoryDto categoryDto) {
        return this.categoryRepository.save(categoryDto);
    }

    //update address
    @PutMapping("kategoria/{id}")
    public ResponseEntity<CategoryDto> updateAddress( @RequestBody CategoryDto kategoriaDetails) {

        return ResponseEntity.ok(this.categoryRepository.save(kategoriaDetails));

    }
    //delete address

    @DeleteMapping("kategoria/{id}")
    public Map<String, Boolean> deleteAddress(@PathVariable(value = "id") int categoryId) throws ResourceNotFoundException {

        CategoryDto categoryDto = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + categoryId));

        this.categoryRepository.delete(categoryDto);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
