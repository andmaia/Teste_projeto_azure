package com.exampleEmNuvem.NuvemProject.dto.pessoaDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListaPessoaDTO {
    private Long id;
    private String nome;

    private Double salario;

    private String situacao;
}
