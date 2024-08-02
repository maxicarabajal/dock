package com.tranqui.demo.service;


import com.tranqui.demo.dto.DuenoDTO;
import com.tranqui.demo.excepciones.ResourceNotFoundException;
import com.tranqui.demo.mappers.DuenoMapper;
import com.tranqui.demo.model.Dueno;
import com.tranqui.demo.repository.IDuenoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DuenoService implements IDuenoService{

    @Autowired
    private IDuenoRepository duenoRepository;

    @Autowired
    private DuenoMapper duenoMapper;

    @Override
    public List<DuenoDTO> getAllDueno() {
        return duenoMapper.listEntityToListDTO(duenoRepository.findAll());
    }

    @Override
    public DuenoDTO findDuenoById(Long id) throws ResourceNotFoundException {
         return duenoMapper.entityToDTO(findDuenoByIdEntity(id));
    }

    @Override
    public Dueno findDuenoByIdEntity(Long id) throws ResourceNotFoundException {
        Optional<Dueno> dueno = duenoRepository.findById(id);
        if(!dueno.isPresent()){
            throw new ResourceNotFoundException("No se encontro dueno con el id: "+id);
        }
        return dueno.get();
    }

    @Override
    public void createDueno(Dueno dueno) {
        duenoRepository.save(dueno);
    }

    @Override
    public void deleteDuenoById(Long id)throws ResourceNotFoundException  {
        duenoRepository.deleteById(id);
    }

    @Override
    public void editDueno(Long id, Dueno dueno)throws ResourceNotFoundException  {
        Dueno duenoAux = findDuenoByIdEntity(id);
        dueno.setIdDueno(duenoAux.getIdDueno());
        duenoRepository.save(dueno);
    }
}
