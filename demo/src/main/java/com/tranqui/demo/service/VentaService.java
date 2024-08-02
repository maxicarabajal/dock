package com.tranqui.demo.service;


import com.tranqui.demo.dto.VentaDTO;
import com.tranqui.demo.excepciones.AutoNotAvailableException;
import com.tranqui.demo.excepciones.ResourceNotFoundException;
import com.tranqui.demo.mappers.VentaMapper;
import com.tranqui.demo.model.Auto;
import com.tranqui.demo.model.Venta;
import com.tranqui.demo.model.enums.Estado;
import com.tranqui.demo.model.enums.FormaDePago;
import com.tranqui.demo.repository.IVentaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private IVentaRepository ventaRepository;

    @Autowired
    private VentaMapper ventaMapper;

    @Override
    public List<VentaDTO> getAllVenta() {
        return ventaMapper.listEntityToListDTO(ventaRepository.findAll());
    }

    @Override
    public VentaDTO findVentaById(Long id)throws ResourceNotFoundException{
        return ventaMapper.entityToDTO(findVentaByIdEntity(id));
    }

    @Override
    public Venta findVentaByIdEntity(Long id)throws ResourceNotFoundException  {
        return ventaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró ninguna venta con el id: " + id));
    }

    @Transactional
    @Override
    public void createVenta(VentaDTO ventaDTO) throws AutoNotAvailableException, ResourceNotFoundException{

        Venta venta = ventaMapper.dtoToEntity(ventaDTO);

        autoEstado(venta.getAuto());//devuelve un true si esta disponible, si no arroja una excepcion
        venta.setDueno(venta.getAuto().getDueno());//Establecemos el titular del auto
        Double precioFinal = calcularPrecioFinal(venta);//Calculamos el precio final segun la forma de pago
        calcularComisiones(venta,precioFinal);// Calculamos las comisiones
        venta.setFechaVenta(LocalDateTime.now()); //Fijamos fecha y horario de la venta

        ventaRepository.save(venta);//Guardamos y completamos la venta

        venta.getVendedor().setCantVentas(+1); //Sumamos la venta al vendedor
        venta.getAuto().setEstado(Estado.COMPRADO); //Cambiamos el estado del auto
    }

    private boolean autoEstado(Auto auto) throws AutoNotAvailableException{
        if(auto.getEstado()!= Estado.DISPONIBLE){
            throw new AutoNotAvailableException("El Auto con patente: "+auto.getPatente()+", No esta disponible.");
        }
        return true;
    }

    private Double calcularPrecioFinal(Venta venta) {
        Double precioFinal = venta.getAuto().getPrecio();
        if (venta.getFormaPago() == FormaDePago.DEBITO || venta.getFormaPago() == FormaDePago.CREDITO) {
            precioFinal *= 1.10;
        }
        return precioFinal;
    }

    private void calcularComisiones(Venta venta, Double precioFinal) {
        venta.setPrecioFinal(precioFinal);
        venta.setComisionVendedor(precioFinal * 0.03);
        venta.setComisionEmpresa(precioFinal * 0.12);
        venta.setMontoDueno(precioFinal * 0.85);
    }

    @Override
    public void deleteVentaById(Long id) throws ResourceNotFoundException {
        Venta venta = findVentaByIdEntity(id);
        ventaRepository.delete(venta);
    }

    @Override
    public void editVenta(Long id, Venta venta)throws ResourceNotFoundException  {
        Venta venta1 = findVentaByIdEntity(id);
        venta.setIdVenta(venta1.getIdVenta());
        ventaRepository.save(venta);
    }
}
