package com.example.exampletest.model.service;

import com.example.exampletest.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> findDateUsed(String to, Integer typeId, Pageable pageable);

    Page<Product> findDateManufature(String from, Integer typeId, Pageable pageable);

    Page<Product> findDateAndType(String from, String to, Integer typeId, Pageable pageable);

    Page<Product> findAll(String from,String to,Integer id, Pageable pageable);

    Page<Product> findAllType(Integer id,Pageable pageable);

    void delete(Integer id);

    Product showProduct(Integer id);
}
