package com.tranqui.demo.model;

import com.tranqui.demo.model.enums.Estado;
import com.tranqui.demo.model.enums.Marca;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idAuto;

    
    @NotBlank(message = "Patente nula, por favor ingresar una patente valida")
    private String patente;

    @NotNull(message = "Marca nula, por favor ingresar una marca valida")
    @Enumerated(EnumType.STRING)
    private Marca marca;

    @NotBlank(message = "Modelo nulo, por favor ingresar un modelo valido")
    private String modelo;

    @NotNull(message = "El precio no debe ser nulo")
    @Min(value = 1,message = "Precio nulo, por favor ingresar un precio valido")
    private double precio;

    @NotNull(message = "Dueno nulo, por favor ingresar un dueno valido")
    @ManyToOne()
    @JoinColumn(name = "id_dueno")
    private Dueno dueno;

    @Enumerated(EnumType.STRING)
    private Estado estado;
}
