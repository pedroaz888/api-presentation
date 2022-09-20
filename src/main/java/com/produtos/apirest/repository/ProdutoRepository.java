package com.produtos.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.apirest.model.Produtos;

public interface ProdutoRepository extends JpaRepository<Produtos,Long> {
	
	

}
