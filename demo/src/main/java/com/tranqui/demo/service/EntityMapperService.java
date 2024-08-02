package com.tranqui.demo.service;

import com.tranqui.demo.excepciones.ResourceNotFoundException;
import com.tranqui.demo.model.Auto;
import com.tranqui.demo.model.Dueno;
import com.tranqui.demo.model.Interesado;
import com.tranqui.demo.model.Vendedor;
import com.tranqui.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntityMapperService {

    @Autowired
    private IVendedorRepository vendedorRepository;

    @Autowired
    private IInteresadoRepository interesadoRepository;

    @Autowired
    private IAutoRepository autoRepository;

    @Autowired
    private IDuenoRepository duenoRepository;

    public Vendedor getVendedor(Long id)throws ResourceNotFoundException {
         Vendedor vendedor = vendedorRepository.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("No se encontro el vendedor con id: "+id));
         return vendedor;
    }

    public Dueno getDueno(Long id)throws ResourceNotFoundException {
        Dueno dueno = duenoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el dueno con id: "+id));
        return dueno;
    }

    public Auto getAuto(Long id)throws ResourceNotFoundException {
        Auto auto = autoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el auto con id: "+id));
        return auto;
    }

    public Interesado getInteresado(Long id)throws ResourceNotFoundException {
        Interesado interesado = interesadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el comprador interesado con id: "+id));
        return interesado;
    }

}
