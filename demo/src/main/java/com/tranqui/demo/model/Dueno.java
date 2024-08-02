package com.tranqui.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dueno {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idDueno;

    private String nombre;
    private String apellido;
    private int dni;
    private LocalDate fechaNac;

    @OneToMany(mappedBy = "dueno", fetch = FetchType.LAZY)
    private List<Auto> autoList;
}
