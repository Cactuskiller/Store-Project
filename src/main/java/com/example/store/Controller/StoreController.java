package com.example.store.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.store.Entity.Customers;
import com.example.store.Entity.Products;
import com.example.store.Entity.Store;
import com.example.store.Repostiory.StoreRepository;

@RestController
@RequestMapping("store")
public class StoreController {

  @Autowired
  StoreRepository strRep;

  @GetMapping
  public List<Store> getALLStores() {
    return strRep.findAll();
  }

  // for each to get all the stores , customers and products
  @GetMapping("/showS")
  public String getStores() {

    String results = "";

    for (Store s : strRep.findAll()) {
      results += "Store id: " + s.getId() + " " + "Store name: " + s.getName() + "<br>";
      for (Customers c : s.getCustomers()) {
        results += "Customer id: " + c.getId() + " " + "Customer name: " + c.getName() + "<br>";
        for (Products p : s.getProducts()) {
          results += "Product id: " + p.getId() + " " + "Product name: " + p.getName() + " " + "Product price: "
              + p.getPrice() + "<br>";
        }
      }
      results += "<br>";
    }
    return results;
  }

  @GetMapping("{id}")
  public ResponseEntity<Store> getStoreById(@PathVariable Long id) {
    Optional<Store> stroeOptional = strRep.findById(id);
    return stroeOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping("/add")
  public Store createStore(@RequestBody Store store) {
    return strRep.save(store);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Void> deleteStore(@PathVariable Long id) {
    if (strRep.existsById(id)) {
      strRep.deleteById(id);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }

}
