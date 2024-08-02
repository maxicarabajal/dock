package com.tranqui.demo.mappers;


import com.tranqui.demo.dto.VentaDTO;
import com.tranqui.demo.excepciones.ResourceNotFoundException;
import com.tranqui.demo.model.Venta;
import com.tranqui.demo.service.EntityMapperService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {AutoMapper.class, VendedorMapper.class, InteresadoMapper.class})
public abstract class VentaMapper {


    @Autowired
    protected EntityMapperService entityMapperService;

    @Mapping(source = "interesado.idInteresado", target = "interesado")
    @Mapping(source = "auto.idAuto", target = "auto")
    @Mapping(source = "auto.dueno.idDueno", target = "dueno")
    @Mapping(source = "vendedor.idVendedor", target = "vendedor")
    public abstract VentaDTO entityToDTO(Venta venta);



    public Venta dtoToEntity(VentaDTO ventaDTO) throws ResourceNotFoundException {
        Venta venta = new Venta();
        venta.setAuto(entityMapperService.getAuto(ventaDTO.getAuto()));
        venta.setInteresado(entityMapperService.getInteresado(ventaDTO.getInteresado()));
        venta.setVendedor(entityMapperService.getVendedor(ventaDTO.getVendedor()));
        venta.setFormaPago(ventaDTO.getFormaPago());
        return venta;
    }

    public abstract List<VentaDTO> listEntityToListDTO(List<Venta> ventaList);

}
