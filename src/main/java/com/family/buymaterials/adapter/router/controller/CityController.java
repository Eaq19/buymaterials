package com.family.buymaterials.adapter.router.controller;

import com.family.buymaterials.domain.service.CityServiceInterface;
import com.family.buymaterials.domain.service.model.CityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("citys")
public class CityController {

    @Autowired
    private CityServiceInterface cityServiceInterface;

    // http://localhost:8888/citys (GET)
    @GetMapping(produces = "application/json")
    public List<CityDTO> getCitys() {
        return cityServiceInterface.findAllCitys();
    }

    // http://localhost:8888/citys/1 (GET)
    @GetMapping(value = "/{id}", produces = "application/json")
    public CityDTO getCityById(@PathVariable Long id) {
        return cityServiceInterface.findCityById(id);
    }

    // http://localhost:8888/citys/add (ADD)
    @PostMapping(value = "/add", produces = "application/json")
    public CityDTO addCity(@RequestBody CityDTO product) {
        return cityServiceInterface.saveCity(product);
    }

    // http://localhost:8888/citys/delete/1 (GET)
    @GetMapping(value = "/delete/{id}", produces = "application/json")
    public ResponseEntity<Object> deleteCity(@PathVariable Long id) {
        if (cityServiceInterface.deleteCity(id).equals("1")) {
            return new ResponseEntity<Object>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    // http://localhost:8888/citys/update (PATCH)
    @PatchMapping(value = "/update", produces = "application/json")
    public ResponseEntity<Object> updateCity(@RequestBody CityDTO productNew) {
        if (cityServiceInterface.updateCity(productNew).equals("1")) {
            return new ResponseEntity<Object>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    // http://localhost:8888/citys/status (GET)
    @GetMapping(value = "/status", produces = "application/json")
    public String status() {
        return "Status done";
    }

    // http://localhost:8888/citys/byName/Edison (GET)
    @GetMapping(value = "/byName/{name}", produces = "application/json")
    public List<CityDTO> likeNameCity(@PathVariable String name) {
        return cityServiceInterface.likeNameCity(name);
    }

    // http://localhost:8888/citys/byDepartament/Edison (GET)
    @GetMapping(value = "/byDepartament/{id}", produces = "application/json")
    public List<CityDTO> likeDepartament(@PathVariable Long id) {
        return cityServiceInterface.likeDepartament(id);
    }

}