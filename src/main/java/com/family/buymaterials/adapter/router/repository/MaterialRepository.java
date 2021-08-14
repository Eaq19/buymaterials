package com.family.buymaterials.adapter.router.repository;

import com.family.buymaterials.domain.repository.h2.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {

    List<Material> findByDescriptionContains(String description);
}
