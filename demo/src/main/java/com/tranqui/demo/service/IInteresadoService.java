package com.tranqui.demo.service;

import com.tranqui.demo.dto.InteresadoDTO;
import com.tranqui.demo.excepciones.ResourceNotFoundException;
import com.tranqui.demo.model.Interesado;

import java.util.List;

public interface IInteresadoService {

    List<InteresadoDTO> getAllInteresado();

    InteresadoDTO findInteresadoById(Long id) throws ResourceNotFoundException ;

    Interesado findInteresadoByIdEntity(Long id) throws ResourceNotFoundException ;

    void createInteresado(Interesado interesado);

    void deleteInteresadoById(Long id) throws ResourceNotFoundException ;

    void editInteresado(Long id, Interesado interesado) throws ResourceNotFoundException;
}
