package com.codemonkey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.codemonkey.entity.Usuario;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface UsuarioRestRepository extends JpaRepository<Usuario, Long> {
}
