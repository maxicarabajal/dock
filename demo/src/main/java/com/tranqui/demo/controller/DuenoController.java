package com.tranqui.demo.controller;


import com.tranqui.demo.dto.DuenoDTO;
import com.tranqui.demo.excepciones.ResourceNotFoundException;
import com.tranqui.demo.model.Dueno;
import com.tranqui.demo.service.IDuenoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DuenoController {

    @Autowired
    private IDuenoService duenoService;

    @GetMapping("/dueno/get/all")
    private List<DuenoDTO> getAllDueno(){
        return duenoService.getAllDueno();
    }

    @GetMapping("/dueno/find/id/{id}")
    private DuenoDTO findDuenoById(@PathVariable Long id) throws ResourceNotFoundException {
        return duenoService.findDuenoById(id);
    }

    @PostMapping("/dueno/create")
    private void createDueno(@RequestBody Dueno dueno){
        duenoService.createDueno(dueno);
    }

    @DeleteMapping("/dueno/delete/{id}")
    private void deleteDueno(@PathVariable Long id) throws ResourceNotFoundException {
        duenoService.deleteDuenoById(id);
    }

    @PutMapping("/dueno/edit/{id}")
    private void editDueno(@PathVariable Long id, @RequestBody Dueno dueno) throws ResourceNotFoundException {
        duenoService.editDueno(id,dueno);
    }
}
