package com.exampleEmNuvem.NuvemProject.repository;

import com.exampleEmNuvem.NuvemProject.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {
}
