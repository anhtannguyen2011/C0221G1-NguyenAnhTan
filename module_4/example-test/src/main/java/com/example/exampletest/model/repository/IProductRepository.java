package com.example.exampletest.model.repository;

import com.example.exampletest.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product,Integer> {
    @Query(nativeQuery = true,value = "select * from product where date_manufacture like %?1% and date_used like %?2% and product_type_id like %?3%")
    Page<Product> findAll(String from,String to, Integer id,Pageable pageable);
    @Query(value = "select * from product where (date_manufacture <= ?1 and date_used >= ?2 ) and product_type_id = ?3 ",nativeQuery = true)
    Page<Product> findDateAndType(String from, String to, Integer typeId, Pageable pageable);

    @Query(value = "select * from product where date_manufacture <= ?1 and product_type_id = ?2 ",nativeQuery = true)
    Page<Product> findDateManufature(String from, Integer typeId, Pageable pageable);

    @Query(value = "select * from product where date_used >= ?1 and product_type_id = ?2 ",nativeQuery = true)
    Page<Product> findDateUsed(String to, Integer typeId, Pageable pageable);


    @Query(value = "select * from product where product_type_id = ?1 ",nativeQuery = true)
    Page<Product> findTypeProduct(Integer id,Pageable pageable);
}
