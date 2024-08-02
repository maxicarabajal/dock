package com.tranqui.demo.service;


import com.tranqui.demo.dto.AutoDTO;
import com.tranqui.demo.excepciones.ListEmptyException;
import com.tranqui.demo.excepciones.ResourceNotFoundException;
import com.tranqui.demo.model.Auto;
import com.tranqui.demo.model.enums.Marca;

import java.util.List;

public interface IAutoService {

    List<AutoDTO> getAllAuto();

    Auto findAutoByIdEntity(Long id) throws ResourceNotFoundException;

    AutoDTO findAutoById(Long id) throws ResourceNotFoundException;

    void createAuto(Auto auto);

    void deleteAutoById(Long id) throws ResourceNotFoundException ;

    void editAuto(Long id, Auto auto) throws ResourceNotFoundException ;

    List<AutoDTO> findAutoByMarca(Marca marca) throws ListEmptyException;
}
