package com.example.store.Controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
  public List<Customers> getAllCustomers(){
    return custRep.findAll();
  }
 
  //understand this code later
  @GetMapping("{id}")
  public ResponseEntity<Customers>GetCustomersById(@PathVariable Long id){
   Optional<Customers> customers = custRep.findById(id);
    return customers.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }


  //in the follwoing the CRUD opperations

  //Create a new customars
  @PostMapping
    public ResponseEntity<Customers> createCustomer(@RequestBody Customers customer) {
        Customers savedCustomer = custRep.save(customer);
        return ResponseEntity.ok(savedCustomer);
    }

    

    @GetMapping("/findByStore/{storeId}")
    public List<Customers> getCustomersByStoreId(@PathVariable Long storeId) {
        return custRep.findByStoreId(storeId);
    }


}
