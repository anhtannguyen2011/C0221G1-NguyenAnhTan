package com.example.exampletest.model.service.Impl;

import com.example.exampletest.model.entity.ProductType;
import com.example.exampletest.model.repository.IProductTypeRepository;
import com.example.exampletest.model.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IProductTypeServiceImpl implements IProductTypeService  {

    @Autowired
    IProductTypeRepository productTypeRepository;
    @Override
    public List<ProductType> findAdd() {
        return productTypeRepository.findAll();
    }
}
