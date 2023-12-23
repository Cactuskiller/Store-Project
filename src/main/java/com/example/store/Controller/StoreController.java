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

  @GetMapping("{id}")
  public ResponseEntity<Store> getStoreById(@PathVariable Long id) {
    Optional<Store> stroeOptional = strRep.findById(id);
    return stroeOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Store> createStore(@RequestBody Store store) {
    Store savedStore = strRep.save(store);
    return ResponseEntity.ok(savedStore);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Void> deleteStore(@PathVariable Long id) {
    if (strRep.existsById(id)) {
      strRep.deleteById(id);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }

}
