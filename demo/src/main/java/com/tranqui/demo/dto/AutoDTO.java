package com.tranqui.demo.dto;


import com.tranqui.demo.model.enums.Estado;
import com.tranqui.demo.model.enums.Marca;
import lombok.Data;

@Data
public class AutoDTO {

    private String patente;
    private Marca marca;
    private String modelo;
    private Double precio;
    private Long idDueno;
    private Estado estado;
}
