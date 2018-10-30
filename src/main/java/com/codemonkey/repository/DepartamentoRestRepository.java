package com.codemonkey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.codemonkey.entity.Departamento;

@RepositoryRestResource
interface DepartamentoRestRepository extends JpaRepository<Departamento, Long> {
}
