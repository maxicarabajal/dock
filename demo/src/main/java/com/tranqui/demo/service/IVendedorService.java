package com.tranqui.demo.service;


import com.tranqui.demo.dto.VendedorDTO;
import com.tranqui.demo.excepciones.ResourceNotFoundException;
import com.tranqui.demo.model.Vendedor;

import java.util.List;

public interface IVendedorService {

    List<VendedorDTO> getAllVendedor();

    VendedorDTO findVendedorById(Long id)throws ResourceNotFoundException ;

    Vendedor findVendedorByIdEntity(Long id)throws ResourceNotFoundException ;

    void createVendedor(Vendedor vendedor);

    void deleteVendedorById(Long id)throws ResourceNotFoundException ;

    void editVendedor(Long id, Vendedor vendedor)throws ResourceNotFoundException;

}
