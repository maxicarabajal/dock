package com.tranqui.demo.mappers;


import com.tranqui.demo.dto.AutoDTO;
import com.tranqui.demo.model.Auto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {DuenoMapper.class})
public interface AutoMapper {


    @Mapping(source = "dueno.idDueno", target = "idDueno")
    public AutoDTO entityToDTO(Auto auto);

    public List<AutoDTO> listEntityToListDTO(List<Auto> autoList);
}
