package com.tranqui.demo.service;


import com.tranqui.demo.dto.InteresadoDTO;
import com.tranqui.demo.excepciones.ResourceNotFoundException;
import com.tranqui.demo.mappers.InteresadoMapper;
import com.tranqui.demo.model.Interesado;
import com.tranqui.demo.repository.IInteresadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InteresadoService implements IInteresadoService {

    @Autowired
    private IInteresadoRepository interesadoRepository;

    @Autowired
    private InteresadoMapper interesadoMapper;

    @Override
    public List<InteresadoDTO> getAllInteresado() {
        return interesadoMapper.listEntityToListDTO(interesadoRepository.findAll());
    }

    @Override
    public InteresadoDTO findInteresadoById(Long id)throws ResourceNotFoundException  {
        return interesadoMapper.entityToDTO(findInteresadoByIdEntity(id));
    }

    @Override
    public Interesado findInteresadoByIdEntity(Long id)throws ResourceNotFoundException  {
        Optional<Interesado> interesado = interesadoRepository.findById(id);
        if(!interesado.isPresent()){
            throw new ResourceNotFoundException("No se encontro ningun comprador interesado con id: "+id);
        }
        return interesado.get();
    }

    @Override
    public void createInteresado(Interesado interesado) {
        interesadoRepository.save(interesado);
    }

    @Override
    public void deleteInteresadoById(Long id)throws ResourceNotFoundException  {
        Interesado interesado = findInteresadoByIdEntity(id);
        interesadoRepository.delete(interesado);
    }

    @Override
    public void editInteresado(Long id, Interesado interesado)throws ResourceNotFoundException  {
        Interesado interesado1 = findInteresadoByIdEntity(id);
        interesado.setIdInteresado(interesado1.getIdInteresado());
        interesadoRepository.save(interesado);
    }
}
