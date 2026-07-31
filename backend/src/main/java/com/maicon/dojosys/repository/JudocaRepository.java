package com.maicon.dojosys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maicon.dojosys.model.Judoca;

@Repository
public interface JudocaRepository extends JpaRepository<Judoca, Long>{

}