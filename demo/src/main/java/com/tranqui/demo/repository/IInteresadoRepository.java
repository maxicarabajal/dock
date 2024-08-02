package com.tranqui.demo.repository;

import com.tranqui.demo.model.Interesado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInteresadoRepository extends JpaRepository<Interesado,Long> {
}
