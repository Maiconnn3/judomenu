package com.maicon.dojosys.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.maicon.dojosys.model.Judoca;
import com.maicon.dojosys.repository.JudocaRepository;

@Service
public class JudocaService{

    private final JudocaRepository repository;

    public JudocaService(JudocaRepository repository){
        this.repository = repository;
    }

    //Validação
    private void validarDados(Judoca j){
        if(j.getNome() == null || j.getNome().isBlank()){
            throw new IllegalArgumentException("O nome não pode ser vazio!"); 
        }
        if(j.getIdade() <= 0){
            throw new IllegalArgumentException("A idade não pode ser vazia ou negativa!"); 
        }
        if(j.getPeso() < 0){
            throw new IllegalArgumentException("O peso não pode ser vazio ou negativo!"); 
        }
        if(j.getFaixa() == null || j.getFaixa().getId() < 1 || j.getFaixa().getId() > 9){
            throw new IllegalArgumentException("A faixa informada é inválida! Escolha um ID entre 1 (Branca) e 9 (Preta)");
        }
    }

    public Judoca matricularJudoca(Judoca j){
        validarDados(j);
        return repository.save(j);
    }

    public List<Judoca> listarTodos(){
        return repository.findAll();
    }

    public Optional<Judoca> buscarPorId(Long id){
        return repository.findById(id);
    }

    public Judoca atualizarJudoca(Long id, Judoca judocaAtualizado){
        Judoca judocaExistente = repository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Judoca não encontrado!"));

        validarDados(judocaAtualizado);

        judocaExistente.setNome(judocaAtualizado.getNome());
        judocaExistente.setIdade(judocaAtualizado.getIdade());
        judocaExistente.setFaixa(judocaAtualizado.getFaixa());
        judocaExistente.setPeso(judocaAtualizado.getPeso());
        return repository.save(judocaExistente);
    }

    public void deletarJudoca(Long id){
        if(!repository.existsById(id)){
            throw new IllegalArgumentException("Judoca não encontrado!"); 
        }
        repository.deleteById(id);
    }
}