package com.example.store.Repostiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.store.Entity.Store;

public interface StoreRepository extends JpaRepository<Store,Long>{

}
