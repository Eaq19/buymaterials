package com.family.buymaterials.adapter.router.repository;

import com.family.buymaterials.domain.repository.h2.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findByNameContains(String name);

}
