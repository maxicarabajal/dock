package com.tranqui.demo.dto;

import com.tranqui.demo.model.Auto;
import com.tranqui.demo.model.Dueno;
import com.tranqui.demo.model.Interesado;
import com.tranqui.demo.model.Vendedor;
import com.tranqui.demo.model.enums.FormaDePago;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class VentaDTO {

    @NotNull(message = "Ingresar el id del comprador")
    private Long interesado;

    @NotNull(message = "Ingresar el id del auto")
    private Long auto;

    private Long dueno;

    @NotNull(message = "Ingresar el id del vendedor")
    private Long vendedor;

    @NotNull(message = "Ingresar la forma de pago")
    private FormaDePago formaPago;

    private LocalDateTime fechaVenta;

    private double precioFinal;

    private double comisionVendedor;

    private double comisionEmpresa;

    private double montoDueno;
}
