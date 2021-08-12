package com.family.buymaterials.adapter.router.repository;

import com.family.buymaterials.domain.repository.h2.model.Product;
import com.family.buymaterials.domain.repository.h2.model.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {

    Set<ProductDetail> findByDetailProduct(Product detailProduct);

}
