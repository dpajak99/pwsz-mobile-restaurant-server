package pl.pwsztar.mobilerestaurant.controllers;

import pl.pwsztar.mobilerestaurant.exceptions.ResourceNotFoundException;
import pl.pwsztar.mobilerestaurant.repositories.WorkerRepository;
import pl.pwsztar.mobilerestaurant.model.WorkerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/restaurant")
public class WorkerController {

    @Autowired
    private WorkerRepository workerRepository;

    //get address
    @GetMapping("pracownik")
    public List<WorkerDto> getAllAddress() {
        return this.workerRepository.findAll();
    }

    //get address by id
    @GetMapping("/pracownik/{id}")
    public ResponseEntity<WorkerDto> getAddressById(@PathVariable(value = "id") int workerId)
            throws ResourceNotFoundException {
        WorkerDto workerDto = workerRepository.findById(workerId)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + workerId));
        return ResponseEntity.ok().body(workerDto);
    }

    //save address
    @PostMapping("pracownik")
    public WorkerDto createAddress(@RequestBody WorkerDto workerDto) {
        return this.workerRepository.save(workerDto);
    }

    //update address
    @PutMapping("pracownik/{id}")
    public ResponseEntity<WorkerDto> updateAddress(@RequestBody WorkerDto worker) {

        return ResponseEntity.ok(this.workerRepository.save(worker));

    }
    //delete address

    @DeleteMapping("pracownik/{id}")
    public Map<String, Boolean> deleteAddress(@PathVariable(value = "id") int workerId) throws ResourceNotFoundException {

        WorkerDto workerDto = workerRepository.findById(workerId)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id: " + workerId));

        this.workerRepository.delete(workerDto);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
