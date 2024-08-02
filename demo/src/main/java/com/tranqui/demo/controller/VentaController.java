package com.tranqui.demo.controller;


import com.tranqui.demo.dto.VendedorDTO;
import com.tranqui.demo.dto.VentaDTO;
import com.tranqui.demo.excepciones.AutoNotAvailableException;
import com.tranqui.demo.excepciones.ResourceNotFoundException;
import com.tranqui.demo.model.Vendedor;
import com.tranqui.demo.model.Venta;
import com.tranqui.demo.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VentaController {

    @Autowired
    private IVentaService ventaService;

    @GetMapping("/venta/get/all")
    private List<VentaDTO> getAllVenta(){
        return ventaService.getAllVenta();
    }

    @GetMapping("/venta/find/id/{id}")
    private VentaDTO findVentaById(@PathVariable Long id) throws ResourceNotFoundException {
        return ventaService.findVentaById(id);
    }

    @PostMapping("/venta/create")
    private void createVenta(@RequestBody VentaDTO ventaDTO) throws ResourceNotFoundException, AutoNotAvailableException {
        ventaService.createVenta(ventaDTO);
    }

    @DeleteMapping("/venta/delete/id/{id}")
    private void deleteVenta(@PathVariable Long id) throws ResourceNotFoundException {
        ventaService.deleteVentaById(id);
    }

    @PutMapping("/venta/edit/id/{id}")
    private void editVenta(@PathVariable Long id, @RequestBody Venta venta) throws ResourceNotFoundException {
        ventaService.editVenta(id,venta);
    }
}
