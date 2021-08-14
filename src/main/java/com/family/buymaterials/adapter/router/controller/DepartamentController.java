package com.family.buymaterials.adapter.router.controller;

import com.family.buymaterials.domain.service.DepartamentServiceInterface;
import com.family.buymaterials.domain.service.model.DepartamentDTO;
import com.family.buymaterials.domain.service.model.DepartamentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("departaments")
public class DepartamentController {

    @Autowired
    private DepartamentServiceInterface departamentServiceInterface;

    // http://localhost:8888/departaments (GET)
    @GetMapping(produces = "application/json")
    public List<DepartamentDTO> getDepartaments() {
        return departamentServiceInterface.findAllDepartaments();
    }

    // http://localhost:8888/departaments/1 (GET)
    @GetMapping(value = "/{id}", produces = "application/json")
    public DepartamentDTO getDepartamentById(@PathVariable Long id) {
        return departamentServiceInterface.findDepartamentById(id);
    }

    // http://localhost:8888/departaments/add (ADD)
    @PostMapping(value = "/add", produces = "application/json")
    public DepartamentDTO addDepartament(@RequestBody DepartamentDTO product) {
        return departamentServiceInterface.saveDepartament(product);
    }

    // http://localhost:8888/departaments/delete/1 (GET)
    @GetMapping(value = "/delete/{id}", produces = "application/json")
    public ResponseEntity<Object> deleteDepartament(@PathVariable Long id) {
        if (departamentServiceInterface.deleteDepartament(id).equals("1")) {
            return new ResponseEntity<Object>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    // http://localhost:8888/departaments/update (PATCH)
    @PatchMapping(value = "/update", produces = "application/json")
    public ResponseEntity<Object> updateDepartament(@RequestBody DepartamentDTO productNew) {
        if (departamentServiceInterface.updateDepartament(productNew).equals("1")) {
            return new ResponseEntity<Object>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    // http://localhost:8888/departaments/status (GET)
    @GetMapping(value = "/status", produces = "application/json")
    public String status() {
        return "Status done";
    }

    // http://localhost:8888/departaments/byName/Edison (GET)
    @GetMapping(value = "/byName/{name}", produces = "application/json")
    public List<DepartamentDTO> likeNameDepartament(@PathVariable String name) {
        return departamentServiceInterface.likeNameDepartament(name);
    }

}