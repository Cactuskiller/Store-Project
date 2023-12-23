package com.example.store.Repostiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.store.Entity.Customers;

public interface CustomersRepository extends JpaRepository<Customers,Long> {
  List<Customers> findByStoreId(Long storeId);


}
