package com.sale_management.sale_campaign.respository;

import com.sale_management.sale_campaign.modules.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<Products,Integer> {

    @Query(value="SELECT * FROM products WHERE product_id = ? ", nativeQuery = true)
    Products findProductById(int productId);

    Optional<Products> findByProductId(int productId);
}
