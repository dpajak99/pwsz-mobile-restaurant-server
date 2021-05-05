package pl.pwsztar.mobilerestaurant.repositories;

import pl.pwsztar.mobilerestaurant.model.OrderDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderDto,Integer> {
}
