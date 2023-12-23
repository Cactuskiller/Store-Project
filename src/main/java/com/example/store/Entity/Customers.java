package com.example.store.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customers {

  
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 Long id;
  
 @Column(name = "Name")
 String name;

 @ManyToOne
 @JoinColumn(name = "store_id")
  Store store;
  
 @ManyToMany(mappedBy = "customers")
 private List<Products> products;

public Long getId() {
  return id;
}

public void setId(Long id) {
  this.id = id;
}

public String getName() {
  return name;
}

public void setName(String name) {
  this.name = name;
}

public Store getStore() {
  return store;
}

public void setStore(Store store) {
  this.store = store;
}

public List<Products> getProducts() {
  return products;
}

public void setProducts(List<Products> products) {
  this.products = products;
}

}
