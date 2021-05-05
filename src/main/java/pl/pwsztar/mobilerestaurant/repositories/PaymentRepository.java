package pl.pwsztar.mobilerestaurant.repositories;

import pl.pwsztar.mobilerestaurant.model.PaymentDataDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentDataDto,Integer> {
}
