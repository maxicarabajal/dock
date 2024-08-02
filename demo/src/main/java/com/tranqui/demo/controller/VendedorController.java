package com.tranqui.demo.controller;


import com.tranqui.demo.dto.VendedorDTO;
import com.tranqui.demo.excepciones.ResourceNotFoundException;
import com.tranqui.demo.model.Vendedor;
import com.tranqui.demo.service.IVendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VendedorController {

    @Autowired
    private IVendedorService vendedorService;

    @GetMapping("/vendedor/get/all")
    private List<VendedorDTO> getAllVendedor(){
        return vendedorService.getAllVendedor();
    }

    @GetMapping("/vendedor/find/id/{id}")
    private VendedorDTO findVendedorById(@PathVariable Long id) throws ResourceNotFoundException {
        return vendedorService.findVendedorById(id);
    }

    @PostMapping("/vendedor/create")
    private void createVendedor(@RequestBody Vendedor vendedor){
        vendedorService.createVendedor(vendedor);
    }

    @DeleteMapping("/vendedor/delete/id/{id}")
    private void deleteVendedor(@PathVariable Long id) throws ResourceNotFoundException {
        vendedorService.deleteVendedorById(id);
    }

    @PutMapping("/vendedor/edit/id/{id}")
    private void editVendedor(@PathVariable Long id, @RequestBody Vendedor vendedor) throws ResourceNotFoundException {
        vendedorService.editVendedor(id,vendedor);
    }

}
