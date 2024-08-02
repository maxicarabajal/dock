package com.tranqui.demo.dto;


import lombok.Data;

import java.time.LocalDate;

@Data
public class VendedorDTO {

    private String nombre;
    private String apellido;
    private int dni;
    private LocalDate fechaNac;
    private LocalDate fechaIngreso;
    private int cantVentas;
}
