package com.maicon.dojosys.repository;

import com.maicon.dojosys.model.Judoca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JudocaRepository extends JpaRepository<Judoca, Long>{

}