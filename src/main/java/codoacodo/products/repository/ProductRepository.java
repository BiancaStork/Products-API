package codoacodo.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import codoacodo.products.models.Product;

@Repository

public interface ProductRepository extends JpaRepository<Product, Long>{

}
