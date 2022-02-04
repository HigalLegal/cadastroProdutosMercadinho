package com.example.demo.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.exception.ResourceNoutFoundException;
import com.example.demo.service.ProdutoService;
import com.example.demo.shared.ProdutoDTO;
import com.example.demo.view.model.ProdutoRequest;
import com.example.demo.view.model.ProdutoResponse;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public ResponseEntity<List<ProdutoResponse>> obterTodos() {
		List<ProdutoDTO> produtos = produtoService.obterTodos();
		
		ModelMapper mapper = new ModelMapper();
		
		List<ProdutoResponse> resposta = produtos.stream()
				.map(produtoDTO -> mapper.map(produtoDTO, ProdutoResponse.class)).collect(Collectors.toList());
		
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<ProdutoResponse>> obterPorId(@PathVariable Integer id) {
		try {
			Optional<ProdutoDTO> dto = produtoService.obterPorId(id);
			
			ProdutoResponse resposta = new ModelMapper().map(dto.get(), ProdutoResponse.class);
			
			Optional<ProdutoResponse> retorno = Optional.of(resposta);

			return new ResponseEntity<>(retorno, HttpStatus.OK);
		} catch(ResourceNoutFoundException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping
	public ResponseEntity<ProdutoResponse> adicionar(@RequestBody ProdutoRequest produtoRequest) {
		
		ModelMapper mapper = new ModelMapper();
		
		
		
		ProdutoDTO produtoDTO = produtoService.adicionar(mapper.map(produtoRequest, ProdutoDTO.class));
		
		ProdutoResponse resposta = mapper.map(produtoDTO, ProdutoResponse.class);
		
		return new ResponseEntity<>(resposta, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id) {
		produtoService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProdutoResponse> atualizar(@PathVariable Integer id, @RequestBody ProdutoRequest produtoRequest) {
		ModelMapper mapper = new ModelMapper();
		
		ProdutoDTO produtoDTO = mapper.map(produtoRequest, ProdutoDTO.class);
		produtoDTO = produtoService.atualizar(id, produtoDTO);
		
		ProdutoResponse resposta = mapper.map(produtoDTO, ProdutoResponse.class);
		
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
}