package pl.pwsztar.mobilerestaurant.repositories;

import pl.pwsztar.mobilerestaurant.model.OrderRateDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRateRepository extends JpaRepository<OrderRateDto, Integer> {
}
