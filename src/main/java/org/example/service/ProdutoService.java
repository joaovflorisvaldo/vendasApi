package org.example.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.example.model.Produto;
import org.example.repository.ProdutoRepository;

import java.util.List;

@Stateless
public class ProdutoService {

    @Inject
    private ProdutoRepository produtoRepository;

    public List<Produto> listar() {
        return produtoRepository.listarTodosProdutos();
    }

    public Produto obterPorId(Integer id) {
        return produtoRepository.listarPorId(id);
    }

    public void salvar(Produto produto) {
        produtoRepository.cadastrarProduto(produto);
    }

    public void atualizar(Produto produto) {
        produtoRepository.atualizarProduto(produto);
    }

    public void deletar(Integer id) {
        produtoRepository.deletarProduto(id);
    }
}
