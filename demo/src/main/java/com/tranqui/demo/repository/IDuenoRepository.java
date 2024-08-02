package com.tranqui.demo.repository;


import com.tranqui.demo.model.Dueno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDuenoRepository extends JpaRepository<Dueno,Long> {


}
