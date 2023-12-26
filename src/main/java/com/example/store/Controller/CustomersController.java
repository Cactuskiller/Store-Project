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
import com.example.store.Repostiory.CustomersRepository;

@RestController
@RequestMapping("customers")
public class CustomersController {

  @Autowired
  CustomersRepository custRep;

  @GetMapping
  public List<Customers> getAllCustomers() {
    return custRep.findAll();
  }

 
  // Find a customer by id
  @GetMapping("/{id}")
  public ResponseEntity<Customers> getCustomersById(@PathVariable Long id) {
    Optional<Customers> customers = custRep.findById(id);
    return customers.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }
  //display all customers
  @GetMapping("/showCustomer")
  public String getCustomers() {
    String results = "";

    for (Customers c : custRep.findAll()) {
      results += "Customer id: " + c.getId() + " " + "Customer name: " + c.getName() + "<br>";
      results += "<br>";
    }
    return results;
  }
  // in the follwoing the CRUD opperations

  // Create a new customer
  @PostMapping("/add")
  public Customers createCustomer(@RequestBody Customers customer) {
    return custRep.save(customer);
  }

  // delete a customer
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
    if (custRep.existsById(id)) {
      custRep.deleteById(id);
      return ResponseEntity.ok().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping("/store/{storeId}")
  public List<Customers> getCustomersByStoreId(@PathVariable Long storeId) {
    return custRep.findByStoreId(storeId);
  }

}
