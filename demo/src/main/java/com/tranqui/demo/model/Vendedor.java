package com.tranqui.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idVendedor;


    private String nombre;
    private String apellido;
    private int dni;
    private LocalDate fechaNac;
    private LocalDate fechaIngreso;

    private int cantVentas;
}
