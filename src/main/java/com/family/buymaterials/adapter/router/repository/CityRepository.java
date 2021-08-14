package com.family.buymaterials.adapter.router.repository;

import com.family.buymaterials.domain.repository.h2.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findByDescriptionContains(String description);

    List<City> findByCityDepartamentId(Long id);

}
