package com.family.buymaterials.adapter.router.controller;

import com.family.buymaterials.domain.service.MaterialServiceInterface;
import com.family.buymaterials.domain.service.model.MaterialDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("materials")
public class MaterialController {

    @Autowired
    private MaterialServiceInterface materialServiceInterface;

    // http://localhost:8888/materials (GET)
    @GetMapping(produces = "application/json")
    public List<MaterialDTO> getMaterials() {
        return materialServiceInterface.findAllMaterials();
    }

    // http://localhost:8888/materials/1 (GET)
    @GetMapping(value = "/{id}", produces = "application/json")
    public MaterialDTO getMaterialById(@PathVariable Long id) {
        return materialServiceInterface.findMaterialById(id);
    }

    // http://localhost:8888/materials/add (ADD)
    @PostMapping(value = "/add", produces = "application/json")
    public MaterialDTO addMaterial(@RequestBody MaterialDTO material) {
        return materialServiceInterface.saveMaterial(material);
    }

    // http://localhost:8888/materials/delete/1 (GET)
    @GetMapping(value = "/delete/{id}", produces = "application/json")
    public ResponseEntity<Object> deleteMaterial(@PathVariable Long id) {
        if (materialServiceInterface.deleteMaterial(id).equals("1")) {
            return new ResponseEntity<Object>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    // http://localhost:8888/materials/update (PATCH)
    @PatchMapping(value = "/update", produces = "application/json")
    public ResponseEntity<Object> updateMaterial(@RequestBody MaterialDTO materialNew) {
        if (materialServiceInterface.updateMaterial(materialNew).equals("1")) {
            return new ResponseEntity<Object>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    // http://localhost:8888/materials/status (GET)
    @GetMapping(value = "/status", produces = "application/json")
    public String status() {
        return "Status done";
    }

    // http://localhost:8888/materials/byName/Edison (GET)
    @GetMapping(value = "/byName/{name}", produces = "application/json")
    public List<MaterialDTO> likeNameMaterial(@PathVariable String name) {
        return materialServiceInterface.likeNameMaterial(name);
    }

}