package com.maicon.dojosys.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "tb_faixas")
public class Faixa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String corFaixa;

    public Long getId(){ 
        return id; 
    }

    public String getCorFaixa(){
        return corFaixa;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setCorFaixa(String corFaixa){
        this.corFaixa = corFaixa;
    }
}
