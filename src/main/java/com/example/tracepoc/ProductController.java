package com.example.tracepoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
public class ProductController {
   @Autowired
   RestTemplate restTemplate;

   List<Product> products = new ArrayList<>();

   @RequestMapping(value = "/products")
   public ResponseEntity<List<Product>> getProductList() {
      return ResponseEntity.ok(products);
   }
   @RequestMapping(value = "/products", method = RequestMethod.POST)
   public ResponseEntity<String> createProducts(@RequestBody Product product) {
      products.add(product);
      return ResponseEntity.ok("createProducts success");
   }
   @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
   public ResponseEntity<String> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
      products.remove(product);

      return ResponseEntity.ok("updateProduct success");
   }
   @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
   public ResponseEntity<String> deleteProduct(@PathVariable("id") String id) {
      products.removeIf(f -> f.getId().equals(id));
      return ResponseEntity.ok("deleteProduct success");
   }
}