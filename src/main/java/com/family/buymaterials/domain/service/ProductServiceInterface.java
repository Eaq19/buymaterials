package com.family.buymaterials.domain.service;

import com.family.buymaterials.domain.service.model.ProductDTO;

import java.util.List;

public interface ProductServiceInterface {

    List<ProductDTO> findAllProducts();

    List<ProductDTO> likeNameProduct(String name);

    ProductDTO findProductById(Long id);

    ProductDTO saveProduct(ProductDTO productNew);

    String deleteProduct(Long id);

    String updateProduct(ProductDTO clientUpdate);

}
