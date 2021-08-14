package com.family.buymaterials.domain.service.impl;

import com.family.buymaterials.adapter.router.repository.DepartamentRepository;
import com.family.buymaterials.domain.repository.h2.model.Departament;
import com.family.buymaterials.domain.service.DepartamentServiceInterface;
import com.family.buymaterials.domain.service.model.DepartamentDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartamentServiceImpl implements DepartamentServiceInterface {

    private DepartamentRepository departamentRepository;
    private ObjectMapper objectMapper;

    @Autowired
    public DepartamentServiceImpl(DepartamentRepository departamentRepository, ObjectMapper objectMapper) {
        this.departamentRepository = departamentRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<DepartamentDTO> findAllDepartaments() {
        List<DepartamentDTO> list = new ArrayList<>();
        List<Departament> listDepartament = departamentRepository.findAll();
        if (!listDepartament.isEmpty()) {
            list = objectMapper.convertValue(listDepartament,
                    new TypeReference<List<DepartamentDTO>>() {
                    });
        }
        return list;
    }

    @Override
    public List<DepartamentDTO> likeNameDepartament(String name) {
        List<DepartamentDTO> list = new ArrayList<>();
        List<Departament> listDepartament = departamentRepository.findByDescriptionContains(name);
        if (!listDepartament.isEmpty()) {
            list = objectMapper.convertValue(listDepartament,
                    new TypeReference<List<DepartamentDTO>>() {
                    });
        }
        return list;
    }

    @Override
    public DepartamentDTO findDepartamentById(Long id) {
        Optional<Departament> departament = departamentRepository.findById(id);
        DepartamentDTO departamentDTO = null;
        if (departament.isPresent()) {
            departamentDTO = objectMapper.convertValue(departament.get(), new TypeReference<DepartamentDTO>() {
            });
        }
        return departamentDTO;
    }

    @Override
    public DepartamentDTO saveDepartament(DepartamentDTO departamentNew) {
        DepartamentDTO response = null;
        if (departamentNew != null) {
            Departament departament = objectMapper.convertValue(departamentNew, new TypeReference<Departament>() {
            });
            response = objectMapper.convertValue(departamentRepository.save(departament), new TypeReference<DepartamentDTO>() {
            });
        }
        return response;
    }

    @Override
    public String deleteDepartament(Long id) {
        if (departamentRepository.findById(id).isPresent()) {
            departamentRepository.deleteById(id);
            return "1";
        }
        return "0";
    }

    @Override
    public String updateDepartament(DepartamentDTO departamentUpdate) {
        Long num = departamentUpdate.getId();
        if (departamentRepository.findById(num).isPresent()) {
            Departament departament = objectMapper.convertValue(departamentUpdate, new TypeReference<Departament>() {
            });
            departamentRepository.save(departament);
            return "1";
        }
        return "0";
    }
}
