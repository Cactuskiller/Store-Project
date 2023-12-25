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
import com.example.store.Entity.Products;
import com.example.store.Repostiory.ProductsRepository;

@RestController
@RequestMapping("/products")
public class ProductsController {

  @Autowired
  ProductsRepository proRep;

  // get alll products
  @GetMapping
  public List<Products> getAllProducts() {
    return proRep.findAll();
  }

  @GetMapping("/showProducts")
  public String getCustomers() {
    String results = "";

    for (Products p : proRep.findAll()) {
      results += "Product id: " + p.getId() + " " + "Product name: " + p.getName() + " " + "Product price: "
          + p.getPrice() + "<br>";
      results += "<br>";
    }
    return results;
  }

  // Get product by ID
  @GetMapping("/{id}")
  public ResponseEntity<Products> getProductById(@PathVariable Long id) {
    Optional<Products> productOptional = proRep.findById(id);
    return productOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  // Get products by store ID ,bassed on the custem function in the product
  // repository
  @GetMapping("/byStore/{storeId}")
  public List<Products> getProductsByStoreId(@PathVariable Long storeId) {
    return proRep.findByStoreId(storeId);
  }

  @PostMapping
  public ResponseEntity<Products> createProduct(@RequestBody Products product) {
    Products saveProduct = proRep.save(product);
    return ResponseEntity.ok(saveProduct);
  }

  // deleteing a product by id
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Void> deletProduct(@PathVariable long id) {
    if (proRep.existsById(id)) {
      proRep.deleteById(id);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }

  }

}
