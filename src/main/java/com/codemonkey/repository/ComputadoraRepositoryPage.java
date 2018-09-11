package com.codemonkey.repository;

import com.codemonkey.entity.Computadora;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputadoraRepositoryPage extends PagingAndSortingRepository<Computadora, Long> {
}
