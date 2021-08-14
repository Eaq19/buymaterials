package com.family.buymaterials.domain.service;

import com.family.buymaterials.domain.service.model.CityDTO;

import java.util.List;

public interface CityServiceInterface {

    List<CityDTO> findAllCitys();

    List<CityDTO> likeNameCity(String name);

    List<CityDTO> likeDepartament(Long id);

    CityDTO findCityById(Long id);

    CityDTO saveCity(CityDTO cityNew);

    String deleteCity(Long id);

    String updateCity(CityDTO cityUpdate);

}
