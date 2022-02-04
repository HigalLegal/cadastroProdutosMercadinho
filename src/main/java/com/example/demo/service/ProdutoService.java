package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.entities.Produto;
import com.example.demo.model.exception.ResourceNoutFoundException;
import com.example.demo.repository.ProdutoRepository;
import com.example.demo.shared.ProdutoDTO;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<ProdutoDTO> obterTodos() {
		List<Produto> produtos = produtoRepository.findAll();
		
		return produtos.stream()
				.map(produto -> new ModelMapper().map(produto, ProdutoDTO.class))
				.collect(Collectors.toList());
		
	}
	
	public Optional<ProdutoDTO> obterPorId(Integer id) {
		Optional<Produto> produtoPorId = produtoRepository.findById(id);
		
		if(produtoPorId.isEmpty()) {
			throw new ResourceNoutFoundException("Produto não encontrado...");
		}
		
		ProdutoDTO retornoDTO = new ModelMapper().map(produtoPorId.get(), ProdutoDTO.class);
		
		return Optional.of(retornoDTO);
		
	}
	
	public ProdutoDTO adicionar(ProdutoDTO produtoDTO) {
		
		produtoDTO.setId(null);
		
		ModelMapper mapper = new ModelMapper();
		
		Produto produto = mapper.map(produtoDTO, Produto.class);
		
		Produto produtoCadastro = produtoRepository.save(produto);
		
		return mapper.map(produtoCadastro, ProdutoDTO.class);
	}
	
	public void deletar(Integer id) {
		
		Optional<Produto> produto = produtoRepository.findById(id);
		
		if(produto.isEmpty()) {
			throw new ResourceNoutFoundException("Produto não encontrado...");
		}
		
		produtoRepository.deleteById(id);
	}
	
	public ProdutoDTO atualizar(Integer id, ProdutoDTO produtoDTO) {
		
		Optional<Produto> produto = produtoRepository.findById(id);
		
		if(produto.isEmpty()) {
			throw new ResourceNoutFoundException("Este produto não existe...");
		}
		
		produtoDTO.setId(id);
		
		ModelMapper modelMapper = new ModelMapper();	
		
		produto = Optional.of(modelMapper.map(produtoDTO, Produto.class));
		
		Produto produtoAtualizado = produtoRepository.save(produto.get());
		
		return modelMapper.map(produtoAtualizado, ProdutoDTO.class);
	}
}
