package com.maicon.dojosys.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_judocas")
public class Judoca{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int idade;
    private double peso;
    
    @ManyToOne
    @JoinColumn(name = "faixa_id")    
    private Faixa faixa;

    public Judoca(){
    }

    public Long getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public int getIdade(){
        return idade;
    }

    public Faixa getFaixa(){
        return faixa;
    }

    public double getPeso(){
        return peso;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public void setFaixa(Faixa faixa){
        this.faixa = faixa;
    }

    public void setPeso(double peso){
        this.peso = peso;
    }
}