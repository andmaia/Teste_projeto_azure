package com.exampleEmNuvem.NuvemProject.controller;

import com.exampleEmNuvem.NuvemProject.dto.pessoaDTO.CadastraPessoaDTO;
import com.exampleEmNuvem.NuvemProject.service.PessoaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    private PessoaService service;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody CadastraPessoaDTO cadastraPessoaDTO){
        service.cadastraPessoa(cadastraPessoaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity listar(@PathVariable Long id){
        var response = service.listaPessoa(id);
        return ResponseEntity.ok(response);
    }

}
