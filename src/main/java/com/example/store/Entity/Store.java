package com.example.store.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Store")
public class Store {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(name = "Name")
  String name;

  @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
  private List<Products> products;

  @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
  private List<Customers> customers;

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

  public List<Products> getProducts() {
    return products;
  }

  public void setProducts(List<Products> products) {
    this.products = products;
  }

  public List<Customers> getCustomers() {
    return customers;
  }

  public void setCustomars(List<Customers> customers) {
    this.customers = customers;
  }

}
