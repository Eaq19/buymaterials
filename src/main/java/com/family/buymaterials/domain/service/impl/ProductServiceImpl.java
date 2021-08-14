package com.family.buymaterials.domain.service.impl;

import com.family.buymaterials.adapter.router.repository.ProductDetailRepository;
import com.family.buymaterials.adapter.router.repository.ProductRepository;
import com.family.buymaterials.domain.repository.h2.model.Product;
import com.family.buymaterials.domain.service.ProductServiceInterface;
import com.family.buymaterials.domain.service.model.ProductDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductServiceInterface {

    private ProductRepository productRepository;
    private ProductDetailRepository productDetailRepository;
    private ObjectMapper objectMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ObjectMapper objectMapper, ProductDetailRepository productDetailRepository) {
        this.productRepository = productRepository;
        this.objectMapper = objectMapper;
        this.productDetailRepository = productDetailRepository;
    }

    @Override
    public List<ProductDTO> findAllProducts() {
        List<ProductDTO> list = new ArrayList<>();
        List<Product> listProduct = productRepository.findAll();
        if (!listProduct.isEmpty()) {
            list = objectMapper.convertValue(listProduct,
                    new TypeReference<List<ProductDTO>>() {
                    });
        }
        return list;
    }

    @Override
    public List<ProductDTO> likeNameProduct(String name) {
        List<ProductDTO> list = new ArrayList<>();
        List<Product> listProduct = productRepository.findByDescriptionContains(name);
        if (!listProduct.isEmpty()) {
            list = objectMapper.convertValue(listProduct,
                    new TypeReference<List<ProductDTO>>() {
                    });
        }
        return list;
    }

    @Override
    public ProductDTO findProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        ProductDTO productDTO = null;
        if (product.isPresent()) {
            productDTO = objectMapper.convertValue(product.get(), new TypeReference<ProductDTO>() {
            });
            /*
            Set<ProductDetail> listDetail = productDetailRepository.findByDetailProduct(product.get());
            if (!listDetail.isEmpty()) {
                productDTO.setProductDetail(objectMapper.convertValue(listDetail, new TypeReference<Set<ProductDetailDTO>>() {
                }));
            }
             */
        }
        return productDTO;
    }

    @Override
    public ProductDTO saveProduct(ProductDTO productNew) {
        ProductDTO response = null;
        if (productNew != null) {
            Product product = objectMapper.convertValue(productNew, new TypeReference<Product>() {
            });
            response = objectMapper.convertValue(productRepository.save(product), new TypeReference<ProductDTO>() {
            });
        }
        return response;
    }

    @Override
    public String deleteProduct(Long id) {
        if (productRepository.findById(id).isPresent()) {
            productRepository.deleteById(id);
            return "1";
        }
        return "0";
    }

    @Override
    public String updateProduct(ProductDTO productUpdate) {
        Long num = productUpdate.getId();
        if (productRepository.findById(num).isPresent()) {
            Product product = objectMapper.convertValue(productUpdate, new TypeReference<Product>() {
            });
            productRepository.save(product);
            return "1";
        }
        return "0";
    }
}
