package com.maicon.judomenu.controller;

import com.maicon.judomenu.model.Judoca;
import com.maicon.judomenu.service.JudocaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/judocas")
public class JudocaController{

    private final JudocaService service;

    public JudocaController(JudocaService service){
        this.service = service;
    }

    //POST
    @PostMapping
    public ResponseEntity<Judoca> criar(@RequestBody Judoca judoca){
        Judoca novoJudoca = service.matricularJudoca(judoca);
        return ResponseEntity.ok(novoJudoca);
    }

    //GET
    @GetMapping
    public ResponseEntity<List<Judoca>> listar(){
        List<Judoca> judocas = service.listarTodos();
        return ResponseEntity.ok(judocas);
    }

    //GET por ID
    @GetMapping("/{id}")
    public ResponseEntity<Judoca> buscar(@PathVariable Long id){
        return service.buscarPorId(id)
            .map(judocaEncontrado -> ResponseEntity.ok(judocaEncontrado))
            .orElse(ResponseEntity.notFound().build());
    }

    //PUT
    @PutMapping("/{id}")
    public ResponseEntity<Judoca> atualizar(@PathVariable Long id, @RequestBody Judoca j){
        try {
            Judoca judocaAtualizado = service.atualizarJudoca(id, j);
            return ResponseEntity.ok(judocaAtualizado);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    //DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        try {
            service.deletarJudoca(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}