package com.vnny8.designpatternsDIO.repository;

import com.vnny8.designpatternsDIO.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
