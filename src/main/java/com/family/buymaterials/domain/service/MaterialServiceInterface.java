package com.family.buymaterials.domain.service;

import com.family.buymaterials.domain.service.model.MaterialDTO;

import java.util.List;

public interface MaterialServiceInterface {

    List<MaterialDTO> findAllMaterials();

    List<MaterialDTO> likeNameMaterial(String name);

    MaterialDTO findMaterialById(Long id);

    MaterialDTO saveMaterial(MaterialDTO materialNew);

    String deleteMaterial(Long id);

    String updateMaterial(MaterialDTO clientUpdate);

}
