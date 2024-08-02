package com.tranqui.demo.service;

import com.tranqui.demo.dto.VentaDTO;
import com.tranqui.demo.excepciones.AutoNotAvailableException;
import com.tranqui.demo.excepciones.ResourceNotFoundException;
import com.tranqui.demo.model.Venta;

import java.util.List;

public interface IVentaService {

    List<VentaDTO> getAllVenta();

    VentaDTO findVentaById(Long id)throws ResourceNotFoundException ;

    Venta findVentaByIdEntity(Long id)throws ResourceNotFoundException ;

    void createVenta(VentaDTO ventaDTO) throws AutoNotAvailableException, ResourceNotFoundException;

    void deleteVentaById(Long id)throws ResourceNotFoundException ;

    void editVenta(Long id, Venta venta)throws ResourceNotFoundException;
}
