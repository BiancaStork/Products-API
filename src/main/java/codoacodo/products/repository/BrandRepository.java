package codoacodo.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import codoacodo.products.models.Brand;

@Repository

public interface BrandRepository extends JpaRepository<Brand, Long> {

}
