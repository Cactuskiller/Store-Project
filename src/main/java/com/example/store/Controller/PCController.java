package com.example.store.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.store.Entity.ProductCustomer;
import com.example.store.Repostiory.PCRepository;

@RestController
@RequestMapping("/ProductCustomers")
public class PCController {

  @Autowired
  PCRepository pcRep;

  @GetMapping
  public List<ProductCustomer> getAllProductCustomers() {
    return pcRep.findAll();
  }

    @PostMapping
    public ProductCustomer createProductCustomer(@RequestBody ProductCustomer productCustomer) {
        return pcRep.save(productCustomer);
    }

}
