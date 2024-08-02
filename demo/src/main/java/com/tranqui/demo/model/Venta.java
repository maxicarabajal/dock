package com.tranqui.demo.model;


import com.tranqui.demo.model.enums.FormaDePago;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venta {



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idVenta;

    @NotNull(message = "Por favor, Ingrese el comprador")
    @ManyToOne
    @JoinColumn(name = "id_interesado")
    private Interesado interesado;

    @NotNull(message = "Por favor, Ingrese el auto a vender")
    @OneToOne(targetEntity = Auto.class)
    @JoinColumn(name = "id_auto")
    private Auto auto;

    @ManyToOne
    @JoinColumn(name = "id_duenoAuto")
    private Dueno dueno;

    @NotNull(message = "Por favor, Ingrese el vendedor")
    @ManyToOne
    @JoinColumn(name = "id_vendedor")
    private Vendedor vendedor;

    @NotNull(message = "Por favor, Ingrese la forma de pago")
    private FormaDePago formaPago;

    private LocalDateTime fechaVenta;

    private double precioFinal;

    private double comisionVendedor;

    private double comisionEmpresa;

    private double montoDueno;
}
