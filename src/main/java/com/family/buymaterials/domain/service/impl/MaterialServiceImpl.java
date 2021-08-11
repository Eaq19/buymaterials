package com.family.buymaterials.domain.service.impl;

import com.family.buymaterials.adapter.router.repository.MaterialRepository;
import com.family.buymaterials.domain.repository.h2.model.Material;
import com.family.buymaterials.domain.service.MaterialServiceInterface;
import com.family.buymaterials.domain.service.model.MaterialDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MaterialServiceImpl implements MaterialServiceInterface {

    private MaterialRepository materialRepository;
    private ObjectMapper objectMapper;

    @Autowired
    public MaterialServiceImpl(MaterialRepository materialRepository, ObjectMapper objectMapper) {
        this.materialRepository = materialRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<MaterialDTO> findAllMaterials() {
        List<MaterialDTO> list = new ArrayList<>();
        List<Material> listMaterial = materialRepository.findAll();
        if (!listMaterial.isEmpty()) {
            list = objectMapper.convertValue(listMaterial,
                    new TypeReference<List<MaterialDTO>>() {
                    });
        }
        return list;
    }

    @Override
    public MaterialDTO findMaterialById(Long id) {
        Optional<Material> material = materialRepository.findById(id);
        MaterialDTO materialDTO = null;
        if (material.isPresent()) {
            materialDTO = objectMapper.convertValue(material.get(), new TypeReference<MaterialDTO>() {
            });
        }
        return materialDTO;
    }

    @Override
    public MaterialDTO saveMaterial(MaterialDTO materialNew) {
        MaterialDTO response = null;
        if (materialNew != null) {
            Material material = objectMapper.convertValue(materialNew, new TypeReference<Material>() {
            });
            response = objectMapper.convertValue(materialRepository.save(material), new TypeReference<MaterialDTO>() {
            });
        }
        return response;
    }

    @Override
    public String deleteMaterial(Long id) {
        if (materialRepository.findById(id).isPresent()) {
            materialRepository.deleteById(id);
            return "Materiale eliminado correctamente.";
        }
        return "Error! El Materiale no existe";
    }

    @Override
    public String updateMaterial(MaterialDTO materialUpdate) {
        Long num = materialUpdate.getId();
        if (materialRepository.findById(num).isPresent()) {
            Material material = objectMapper.convertValue(materialUpdate, new TypeReference<Material>() {
            });
            materialRepository.save(material);
            return "Materiale modificado";
        }
        return "Error al modificar el Materiale";
    }
}
