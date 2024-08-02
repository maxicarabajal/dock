package com.tranqui.demo.mappers;

import com.tranqui.demo.dto.AutoDTO;
import com.tranqui.demo.dto.DuenoDTO;
import com.tranqui.demo.model.Auto;
import com.tranqui.demo.model.Dueno;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {AutoMapper.class})
public interface DuenoMapper {

    @Mapping(source = "autoList", target = "autoDTOList")
    public DuenoDTO entityToDTO(Dueno dueno);

    public List<DuenoDTO> listEntityToListDTO(List<Dueno> duenoList);

}
