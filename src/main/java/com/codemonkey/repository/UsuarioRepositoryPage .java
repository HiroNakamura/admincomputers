package com.codemonkey.repository;

import com.codemonkey.entity.Usuario;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositoryPage extends PagingAndSortingRepository<Usuario, Long> {
}
