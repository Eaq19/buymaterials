package com.family.buymaterials.adapter.router.controller;

import com.family.buymaterials.domain.service.ProductServiceInterface;
import com.family.buymaterials.domain.service.model.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductServiceInterface productServiceInterface;

    // http://localhost:8888/products (GET)
    @GetMapping(produces = "application/json")
    public List<ProductDTO> getProducts() {
        return productServiceInterface.findAllProducts();
    }

    // http://localhost:8888/products/1 (GET)
    @GetMapping(value = "/{id}", produces = "application/json")
    public ProductDTO getProductById(@PathVariable Long id) {
        return productServiceInterface.findProductById(id);
    }

    // http://localhost:8888/products/add (ADD)
    @PostMapping(value = "/add", produces = "application/json")
    public ProductDTO addProduct(@RequestBody ProductDTO product) {
        return productServiceInterface.saveProduct(product);
    }

    // http://localhost:8888/products/delete/1 (GET)
    @GetMapping(value = "/delete/{id}", produces = "application/json")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id) {
        if (productServiceInterface.deleteProduct(id).equals("1")) {
            return new ResponseEntity<Object>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    // http://localhost:8888/products/update (PATCH)
    @PatchMapping(value = "/update", produces = "application/json")
    public ResponseEntity<Object> updateProduct(@RequestBody ProductDTO productNew) {
        if (productServiceInterface.updateProduct(productNew).equals("1")) {
            return new ResponseEntity<Object>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    // http://localhost:8888/products/status (GET)
    @GetMapping(value = "/status", produces = "application/json")
    public String status() {
        return "Status done";
    }

    // http://localhost:8888/products/byName/Edison (GET)
    @GetMapping(value = "/byName/{name}", produces = "application/json")
    public List<ProductDTO> likeNameProduct(@PathVariable String name) {
        return productServiceInterface.likeNameProduct(name);
    }

}