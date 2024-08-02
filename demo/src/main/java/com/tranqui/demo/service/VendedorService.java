package com.tranqui.demo.service;


import com.tranqui.demo.dto.VendedorDTO;
import com.tranqui.demo.excepciones.ResourceNotFoundException;
import com.tranqui.demo.mappers.VendedorMapper;
import com.tranqui.demo.model.Vendedor;
import com.tranqui.demo.repository.IVendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendedorService implements IVendedorService{

    @Autowired
    private IVendedorRepository vendedorRepository;

    @Autowired
    private VendedorMapper vendedorMapper;

    @Override
    public List<VendedorDTO> getAllVendedor() {
        return vendedorMapper.listEntityToListDTO(vendedorRepository.findAll());
    }

    @Override
    public VendedorDTO findVendedorById(Long id)throws ResourceNotFoundException  {
        return vendedorMapper.entityToDTO(findVendedorByIdEntity(id));
    }

    @Override
    public Vendedor findVendedorByIdEntity(Long id)throws ResourceNotFoundException  {
        Optional<Vendedor> vendedor = vendedorRepository.findById(id);
        if(!vendedor.isPresent()) {
            throw new ResourceNotFoundException("No se encontro el vendedor con id: " + id);
        }
        return vendedor.get();
    }

    @Override
    public void createVendedor(Vendedor vendedor) {
        vendedor.setCantVentas(0);
        vendedorRepository.save(vendedor);
    }

    @Override
    public void deleteVendedorById(Long id)throws ResourceNotFoundException  {
        Vendedor vendedor = findVendedorByIdEntity(id);
        vendedorRepository.delete(vendedor);
    }

    @Override
    public void editVendedor(Long id, Vendedor vendedor)throws ResourceNotFoundException {
        Vendedor vendedor1 = findVendedorByIdEntity(id);
        vendedor.setIdVendedor(vendedor1.getIdVendedor());
        vendedorRepository.save(vendedor);
    }
}
