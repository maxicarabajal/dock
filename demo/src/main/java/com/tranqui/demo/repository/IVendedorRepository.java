package com.tranqui.demo.repository;


import com.tranqui.demo.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVendedorRepository extends JpaRepository<Vendedor,Long> {
}
