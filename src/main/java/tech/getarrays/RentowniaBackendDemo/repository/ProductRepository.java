package tech.getarrays.RentowniaBackendDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.getarrays.RentowniaBackendDemo.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product getProductById(Long productId);
}
