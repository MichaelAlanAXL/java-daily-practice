package dev.michael.day04.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.michael.day04.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
    
}
