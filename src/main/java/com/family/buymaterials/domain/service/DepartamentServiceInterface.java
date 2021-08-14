package com.family.buymaterials.domain.service;

import com.family.buymaterials.domain.service.model.DepartamentDTO;

import java.util.List;

public interface DepartamentServiceInterface {

    List<DepartamentDTO> findAllDepartaments();

    List<DepartamentDTO> likeNameDepartament(String name);

    DepartamentDTO findDepartamentById(Long id);

    DepartamentDTO saveDepartament(DepartamentDTO departamentNew);

    String deleteDepartament(Long id);

    String updateDepartament(DepartamentDTO departamentUpdate);

}
