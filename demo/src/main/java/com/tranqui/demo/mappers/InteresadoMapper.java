package com.tranqui.demo.mappers;


import com.tranqui.demo.dto.InteresadoDTO;
import com.tranqui.demo.model.Interesado;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface InteresadoMapper {

    public InteresadoDTO entityToDTO(Interesado interesado);

    public List<InteresadoDTO> listEntityToListDTO(List<Interesado> interesadoList);
}
