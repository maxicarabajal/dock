package com.tranqui.demo.controller;


import com.tranqui.demo.dto.AutoDTO;
import com.tranqui.demo.excepciones.AutoNotAvailableException;
import com.tranqui.demo.excepciones.ListEmptyException;
import com.tranqui.demo.excepciones.ResourceNotFoundException;
import com.tranqui.demo.model.Auto;
import com.tranqui.demo.model.enums.Marca;
import com.tranqui.demo.service.IAutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AutoController {

    @Autowired
    private IAutoService autoService;

    @GetMapping("/auto/get/all")
    private List<AutoDTO> getAllAuto(){
        return autoService.getAllAuto();
    }

    @GetMapping("/auto/find/id/{id}")
    private AutoDTO findAutoById(@PathVariable Long id) throws ResourceNotFoundException {
        return autoService.findAutoById(id);
    }

    @GetMapping("/auto/find/marca/{marca}")
    private List<AutoDTO> findAutoByMarca(@PathVariable Marca marca) throws ListEmptyException {
        return autoService.findAutoByMarca(marca);
    }

    @PostMapping("/auto/create")
    private void createAuto(@Valid @RequestBody Auto auto) throws AutoNotAvailableException {
        autoService.createAuto(auto);
    }

    @DeleteMapping("/auto/delete/{id}")
    private void deleteAuto(@PathVariable Long id) throws ResourceNotFoundException {
        autoService.deleteAutoById(id);
    }

    @PutMapping("/auto/edit/{id}")
    private void editAuto(@PathVariable Long id, @RequestBody Auto auto) throws ResourceNotFoundException {
        autoService.editAuto(id,auto);
    }


}
