package com.family.buymaterials.adapter.router.repository;

import com.family.buymaterials.domain.repository.h2.model.Departament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentRepository extends JpaRepository<Departament, Long> {
}
