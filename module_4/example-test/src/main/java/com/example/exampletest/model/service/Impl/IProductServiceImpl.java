package com.example.exampletest.model.service.Impl;

import com.example.exampletest.model.entity.Product;
import com.example.exampletest.model.repository.IProductRepository;
import com.example.exampletest.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IProductServiceImpl implements IProductService {
    @Autowired
    IProductRepository productRepository;

    @Override
    public Page<Product> findDateUsed(String to, Integer typeId, Pageable pageable) {
        return productRepository.findDateUsed(to,typeId,pageable);
    }

    @Override
    public Page<Product> findDateManufature(String from, Integer typeId, Pageable pageable) {
        return productRepository.findDateManufature(from,typeId,pageable);
    }

    @Override
    public Page<Product> findDateAndType(String from, String to, Integer typeId, Pageable pageable) {
        return productRepository.findDateAndType(from,to,typeId,pageable);
    }

    @Override
    public Page<Product> findAll(String from, String to, Integer typeId,Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> findAllType(Integer id,Pageable pageable) {
        return productRepository.findTypeProduct(id,pageable);
    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product showProduct(Integer id) {
        return productRepository.findById(id).orElse(null);
    }
}
