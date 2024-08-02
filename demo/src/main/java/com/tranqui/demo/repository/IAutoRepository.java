package com.tranqui.demo.repository;


import com.tranqui.demo.model.Auto;
import com.tranqui.demo.model.enums.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAutoRepository extends JpaRepository<Auto,Long>{

    @Query("SELECT a FROM Auto a WHERE a.marca = :marca")
    List<Auto> findAutoByMarca(@Param("marca")Marca marca);
}
