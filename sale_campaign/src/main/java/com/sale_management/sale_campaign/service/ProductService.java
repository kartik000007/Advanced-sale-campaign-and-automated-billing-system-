package com.sale_management.sale_campaign.service;
import com.sale_management.sale_campaign.modules.Price_History;
import com.sale_management.sale_campaign.modules.Products;
import com.sale_management.sale_campaign.modules.product_pagination;
import com.sale_management.sale_campaign.respository.PriceHistoryRepo;
import com.sale_management.sale_campaign.respository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    PriceHistoryRepo priceHistoryRepo;
    @Autowired
    ProductRepo saleRepository;
    public ResponseEntity<Products> saveSingleProduct(Products products) {
        try{
            saleRepository.save(products);
            return new ResponseEntity<>(products,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Products>> saveProduct(List<Products> productsList) {
        try {
            saleRepository.saveAll(productsList);
            return ResponseEntity.ok(productsList);
        }catch (Exception e) {
            return ResponseEntity.ok(null);
        }
    }

    public product_pagination getProductPagination(int pageNumber, int pageSize) {
            List<Products> productsList = new ArrayList<>();
        try {
            Pageable pageable = PageRequest.of(pageNumber,pageSize);
            Page<Products> pageProducts=saleRepository.findAll(pageable);
            productsList = pageProducts.getContent();

            return new product_pagination(productsList, pageNumber, pageSize,12);
        }
        catch (Exception e) {
            return new product_pagination(productsList,0,0,0);
        }
    }
}
