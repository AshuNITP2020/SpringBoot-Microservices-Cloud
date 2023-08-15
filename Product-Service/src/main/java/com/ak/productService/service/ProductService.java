package com.ak.productService.service;


import java.util.*;
import com.ak.productService.dto.ProductRequest;
import com.ak.productService.dto.ProductResponse;
import com.ak.productService.model.Product;
import com.ak.productService.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private  final ProductRepository productRepository;

    //Lombok gives annotaion for that
//    public ProductService(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    public void createProduct(ProductRequest productRequest){
        //Creating instance of the type Product
        Product product = Product.builder()
                .name(productRequest.getName())
                .desc(productRequest.getDesc())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        //log.info("Product"+product.getId()+"is saved");
        //We can use placeholder
        log.info("Product {} is saved",product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> allProducts = productRepository.findAll();
        //mapping product to productResponse class
        return allProducts.stream()
                .map(this::mapToProductResponse)
                .toList();

    }

    public ProductResponse mapToProductResponse(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .desc(product.getDesc())
                .price(product.getPrice())
                .build();
    }
}
