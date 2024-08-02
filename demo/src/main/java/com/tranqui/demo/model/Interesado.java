package com.tranqui.demo.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Interesado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idInteresado;

    @NotBlank(message = "Ingresar el nombre del cliente interesado")
    private String nombre;

    private String apellido;
    private int dni;
    private LocalDate fechaNac;
    private String gmail;
    private int telefono;

}
