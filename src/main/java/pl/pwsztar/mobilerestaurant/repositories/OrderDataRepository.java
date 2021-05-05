package pl.pwsztar.mobilerestaurant.repositories;

import pl.pwsztar.mobilerestaurant.model.OrderDataDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDataRepository extends JpaRepository<OrderDataDto,Integer> {
}
