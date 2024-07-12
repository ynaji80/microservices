package com.example.productapi.services;

import com.example.productapi.domain.Product;
import com.example.productapi.repository.ProductRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {


    private final ProductRepo productRepo;

    @Override
    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }
    @Override
    public Product getProductById(Long id) throws Exception{
        Optional<Product> product = productRepo.findById(id);
        if (product.isEmpty()){
            throw new Exception("No product with ID "+id);
        }
        return product.get();
    }
    @Override
    public Product createProduct(Product product){
        return productRepo.save(product);
    }
    @Override
    public void deleteProduct(Long id) throws Exception {
        Product product = getProductById(id);
        productRepo.delete(product);
    }
}