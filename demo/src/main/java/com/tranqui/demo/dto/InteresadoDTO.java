package com.tranqui.demo.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InteresadoDTO {
    private String nombre;
    private String apellido;
    private int dni;
    private LocalDate fechaNac;
    private String gmail;
    private int telefono;

}
