package com.family.buymaterials.domain.service;

import com.family.buymaterials.domain.service.model.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductServiceInterface {

    List<ProductDTO> findAllProducts();

    ProductDTO findProductById(Long id);

    ProductDTO saveProduct(ProductDTO productNew);

    String deleteProduct(Long id);

    String updateProduct(ProductDTO clientUpdate);

}
