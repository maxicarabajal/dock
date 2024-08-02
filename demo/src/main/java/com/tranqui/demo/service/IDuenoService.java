package com.tranqui.demo.service;


import com.tranqui.demo.dto.DuenoDTO;
import com.tranqui.demo.excepciones.ResourceNotFoundException;
import com.tranqui.demo.model.Dueno;

import java.util.List;

public interface IDuenoService {

    List<DuenoDTO> getAllDueno();

    DuenoDTO findDuenoById(Long id) throws ResourceNotFoundException;

    Dueno findDuenoByIdEntity(Long id) throws ResourceNotFoundException;

    void createDueno(Dueno dueno);

    void deleteDuenoById(Long id) throws ResourceNotFoundException ;

    void editDueno(Long id, Dueno dueno) throws ResourceNotFoundException ;
}
