package com.tranqui.demo.dto;


import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class DuenoDTO {

    private String nombre;
    private String apellido;
    private int dni;
    private LocalDate fechaNac;
    private List<AutoDTO> autoDTOList;
}
