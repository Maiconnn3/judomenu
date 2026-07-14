package com.maicon.judomenu.repository;

import com.maicon.judomenu.model.Judoca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JudocaRepository extends JpaRepository<Judoca, Long>{

}