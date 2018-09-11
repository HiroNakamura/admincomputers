package com.codemonkey.repository;

import com.codemonkey.entity.Computadora;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("computadoraRepository")
public interface ComputadoraRepository extends JpaRepository<Computadora, Long> {

}
