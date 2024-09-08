package com.vnny8.designpatternsDIO.repository;

import com.vnny8.designpatternsDIO.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, String> {
}
