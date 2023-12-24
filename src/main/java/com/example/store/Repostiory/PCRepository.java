package com.example.store.Repostiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.store.Entity.ProductCustomer;

public interface PCRepository extends JpaRepository<ProductCustomer, Long> {

}
