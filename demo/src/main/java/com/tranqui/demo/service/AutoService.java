package com.tranqui.demo.service;


import com.tranqui.demo.dto.AutoDTO;
import com.tranqui.demo.excepciones.ListEmptyException;
import com.tranqui.demo.excepciones.ResourceNotFoundException;
import com.tranqui.demo.mappers.AutoMapper;
import com.tranqui.demo.model.Auto;
import com.tranqui.demo.model.enums.Estado;
import com.tranqui.demo.model.enums.Marca;
import com.tranqui.demo.repository.IAutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoService implements IAutoService {

    @Autowired
    private IAutoRepository autoRepository;


    @Autowired
    private AutoMapper autoMapper;

    @Override
    public List<AutoDTO> getAllAuto() {
        return autoMapper.listEntityToListDTO(autoRepository.findAll());
    }

    @Override
    public Auto findAutoByIdEntity(Long id) throws ResourceNotFoundException {
        Optional<Auto> auto = autoRepository.findById(id);
        if(!auto.isPresent()){
            throw new ResourceNotFoundException("No se encontro un auto con id: "+id);
        }
        return auto.get();
    }

    @Override
    public AutoDTO findAutoById(Long id) throws ResourceNotFoundException{
        return autoMapper.entityToDTO(findAutoByIdEntity(id));
    }

    @Override
    public void createAuto(Auto auto) {
        auto.setEstado(Estado.DISPONIBLE);
        autoRepository.save(auto);
    }

    @Override
    public void deleteAutoById(Long id)throws ResourceNotFoundException  {
        autoRepository.deleteById(id);
    }

    @Override
    public void editAuto(Long id, Auto auto)throws ResourceNotFoundException  {
        Auto autoAux = findAutoByIdEntity(id);
        auto.setIdAuto(autoAux.getIdAuto());
        autoRepository.save(auto);
    }

    @Override
    public List<AutoDTO> findAutoByMarca(Marca marca) throws ListEmptyException{
        List<Auto> lista = autoRepository.findAutoByMarca(marca);
        if(lista.isEmpty()){
            throw new ListEmptyException("No se encontro registros sobre la marca: "+marca);
        }
        return autoMapper.listEntityToListDTO(lista);
    }
}
