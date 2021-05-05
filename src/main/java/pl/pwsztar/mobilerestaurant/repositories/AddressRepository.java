package pl.pwsztar.mobilerestaurant.repositories;

import org.springframework.data.jpa.repository.Query;
import pl.pwsztar.mobilerestaurant.model.AddressDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<AddressDto, Integer> {
  @Query("SELECT a.address FROM ClientDto a WHERE a.id = ?1")
  AddressDto findByUserId(int userId);
}
