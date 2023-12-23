package com.example.store.Repostiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.store.Entity.Products;

public interface ProductsRepository extends JpaRepository<Products, Long>{
  List<Products> findByStoreId(Long storeId);

}
