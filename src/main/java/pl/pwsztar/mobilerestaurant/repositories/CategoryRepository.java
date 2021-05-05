package pl.pwsztar.mobilerestaurant.repositories;

import pl.pwsztar.mobilerestaurant.model.CategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryDto, Integer> {
}
