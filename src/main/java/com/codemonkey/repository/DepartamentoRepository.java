package com.codemonkey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.codemonkey.entity.Departamento;


@Repository("departamentoRepository")
public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{

}
