package com.sale_management.sale_campaign.controller;

import com.sale_management.sale_campaign.modules.Products;
import com.sale_management.sale_campaign.modules.product_pagination;
import com.sale_management.sale_campaign.respository.ProductRepo;
import com.sale_management.sale_campaign.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    ProductService saleService;

    @Autowired
    private ProductRepo saleRepo;

    @PostMapping("/AddProduct")
    public ResponseEntity<Products> createProduct(@RequestBody Products product) {
        return saleService.saveSingleProduct(product);
        // your code here
    }

    @PostMapping("/AddMultipleProducts")
    public ResponseEntity<List<Products>> createProduct(@RequestBody List<Products> products) {
        // your code here
        return saleService.saveProduct(products);
    }

    @GetMapping("/getProductPagination")
    //get product list with pagination functionality using page number and page size parameters.
    public product_pagination getProductPagination(
            @RequestHeader(value = "page") int pageNumber,
            @RequestHeader(value = "size") int pageSize
    ) {

        return saleService.getProductPagination(pageNumber, pageSize);

    }


    @GetMapping()
    //get all products from the database.
    private List<Products> getAllProducts() {
        return saleRepo.findAll();
    }

    @GetMapping("/{productId}")
    //get a single product by id.
    private Products getProductById(@PathVariable int productId) {
        return saleRepo.findById(productId).orElse(null);
    }

}



