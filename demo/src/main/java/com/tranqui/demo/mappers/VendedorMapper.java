package com.tranqui.demo.mappers;


import com.tranqui.demo.dto.VendedorDTO;
import com.tranqui.demo.model.Vendedor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VendedorMapper {

    public VendedorDTO entityToDTO(Vendedor vendedor);

    public List<VendedorDTO> listEntityToListDTO(List<Vendedor> vendedorList);
}
