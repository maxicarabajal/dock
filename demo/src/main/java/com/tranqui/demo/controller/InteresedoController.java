package com.tranqui.demo.controller;


import com.tranqui.demo.dto.InteresadoDTO;
import com.tranqui.demo.model.Interesado;
import com.tranqui.demo.service.IInteresadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InteresedoController {

    @Autowired
    private IInteresadoService interesadoService;


    @GetMapping("/interesado/get/all")
    private List<InteresadoDTO> getAllInteresado(){
        return interesadoService.getAllInteresado();
    }

    @GetMapping("/interesado/find/id/{id}")
    private InteresadoDTO findInteresadoById(@PathVariable Long id){
        return interesadoService.findInteresadoById(id);
    }

    @PostMapping("/interesado/create")
    private void createInteresado(@RequestBody Interesado interesado){
        interesadoService.createInteresado(interesado);
    }

    @DeleteMapping("/interesado/delete/id/{id}")
    private void deleteInteresadoById(@PathVariable Long id){
        interesadoService.deleteInteresadoById(id);
    }

    @PutMapping("/interesado/edit/id/{id}")
    private void editInteresado(@PathVariable Long id, @RequestBody Interesado interesado){
        interesadoService.editInteresado(id,interesado);
    }

}
