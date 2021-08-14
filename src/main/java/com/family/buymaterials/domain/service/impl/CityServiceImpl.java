package com.family.buymaterials.domain.service.impl;

import com.family.buymaterials.adapter.router.repository.CityRepository;
import com.family.buymaterials.domain.repository.h2.model.City;
import com.family.buymaterials.domain.repository.h2.model.City;
import com.family.buymaterials.domain.service.CityServiceInterface;
import com.family.buymaterials.domain.service.model.CityDTO;
import com.family.buymaterials.domain.service.model.CityDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityServiceInterface {

    private CityRepository cityRepository;
    private ObjectMapper objectMapper;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository, ObjectMapper objectMapper) {
        this.cityRepository = cityRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<CityDTO> findAllCitys() {
        List<CityDTO> list = new ArrayList<>();
        List<City> listCity = cityRepository.findAll();
        if (!listCity.isEmpty()) {
            list = objectMapper.convertValue(listCity,
                    new TypeReference<List<CityDTO>>() {
                    });
        }
        return list;
    }

    @Override
    public List<CityDTO> likeNameCity(String name) {
        List<CityDTO> list = new ArrayList<>();
        List<City> listCity = cityRepository.findByDescriptionContains(name);
        if (!listCity.isEmpty()) {
            list = objectMapper.convertValue(listCity,
                    new TypeReference<List<CityDTO>>() {
                    });
        }
        return list;
    }

    @Override
    public List<CityDTO> likeDepartament(Long id) {
        List<CityDTO> list = new ArrayList<>();
        List<City> listCity = cityRepository.findByCityDepartamentId(id);
        if (!listCity.isEmpty()) {
            list = objectMapper.convertValue(listCity,
                    new TypeReference<List<CityDTO>>() {
                    });
        }
        return list;
    }

    @Override
    public CityDTO findCityById(Long id) {
        Optional<City> city = cityRepository.findById(id);
        CityDTO cityDTO = null;
        if (city.isPresent()) {
            cityDTO = objectMapper.convertValue(city.get(), new TypeReference<CityDTO>() {
            });
        }
        return cityDTO;
    }

    @Override
    public CityDTO saveCity(CityDTO cityNew) {
        CityDTO response = null;
        if (cityNew != null) {
            City city = objectMapper.convertValue(cityNew, new TypeReference<City>() {
            });
            response = objectMapper.convertValue(cityRepository.save(city), new TypeReference<CityDTO>() {
            });
        }
        return response;
    }

    @Override
    public String deleteCity(Long id) {
        if (cityRepository.findById(id).isPresent()) {
            cityRepository.deleteById(id);
            return "Ciudad eliminado correctamente.";
        }
        return "Error! El Ciudad no existe";
    }

    @Override
    public String updateCity(CityDTO cityUpdate) {
        Long num = cityUpdate.getId();
        if (cityRepository.findById(num).isPresent()) {
            City city = objectMapper.convertValue(cityUpdate, new TypeReference<City>() {
            });
            cityRepository.save(city);
            return "1";
        }
        return "0";
    }
}
