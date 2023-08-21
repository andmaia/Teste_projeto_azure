package com.exampleEmNuvem.NuvemProject.service;

import com.exampleEmNuvem.NuvemProject.dto.pessoaDTO.CadastraPessoaDTO;
import com.exampleEmNuvem.NuvemProject.dto.pessoaDTO.ListaPessoaDTO;
import com.exampleEmNuvem.NuvemProject.model.Pessoa;
import com.exampleEmNuvem.NuvemProject.repository.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;


    public void cadastraPessoa(CadastraPessoaDTO pessoaDTO){
        var pessoa = new Pessoa();

        pessoa.setId(null);
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setSalario(pessoaDTO.getSalario());
        pessoa.setCriacao(LocalDateTime.now());
        pessoa.setSituacao(verificaRenda(pessoaDTO.getSalario()));

        repository.save(pessoa);
    }


public ListaPessoaDTO listaPessoa(Long id){
        ListaPessoaDTO listaPessoaDTO = new ListaPessoaDTO();

        try{
            var obj = repository.getReferenceById(id);

            listaPessoaDTO.setId(obj.getId());
            listaPessoaDTO.setNome(obj.getNome());
            listaPessoaDTO.setSalario(obj.getSalario());
            listaPessoaDTO.setSituacao(obj.getSituacao());

            return listaPessoaDTO;
        }catch (EntityNotFoundException e){
            throw new EntityNotFoundException("Entidade não encontrada");
        }catch (Exception e){
            e.getMessage();
        }

        return listaPessoaDTO;

}

    public String verificaRenda(double renda){
        if (renda <= 10000) {
            return "Pobre";
        } else if (renda > 10000 && renda <= 50000) {
            return "Classe Média";
        } else {
            return "Rico";
        }
    }

}
