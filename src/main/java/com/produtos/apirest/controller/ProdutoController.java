package com.produtos.apirest.controller;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.produtos.apirest.model.DadosBasicos;
import com.produtos.apirest.model.Produtos;
import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins="*")
public class ProdutoController {
	
	
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	@ApiOperation(value="Retorna uma lista de produtos")
	public List<Produtos>listaDeProdutos(){
		return produtoRepository.findAll();
		
	}
	
	@GetMapping("/produtos/{id}")
	@ApiOperation(value="Retorna um produto único")
	public ResponseEntity<DadosBasicos>detalhar(@PathVariable Long id){
		Optional<Produtos> detalhe = produtoRepository.findById(id);
		if(detalhe.isPresent()) {
			return ResponseEntity.ok(new DadosBasicos (detalhe.get()));
				
		
		}
		return ResponseEntity.notFound().build();
	
		
	}
	
	@PostMapping("/produtos")
	@ApiOperation(value="Salva um produtos")
	public Produtos salvaProduto(@RequestBody Produtos produto) {
		return produtoRepository.save(produto);
		
	}
	
	@DeleteMapping("/produtos/{id}")
	@ApiOperation(value="Deleta um produtos")
	public ResponseEntity<?>remover(@PathVariable Long id){
		Optional<Produtos> optional = produtoRepository.findById(id);
		if(optional.isPresent()) {
			produtoRepository.deleteById(id);
			return ResponseEntity.ok().build();
			
	}

			return ResponseEntity.notFound().build();
	
 }
	
	@PutMapping("/produtos")
	@ApiOperation(value="Atualiza um produtos")
	public Produtos atualizaProduto(@RequestBody Produtos produto) {
		
		return produtoRepository.save(produto);
		
	}
	
	
}


