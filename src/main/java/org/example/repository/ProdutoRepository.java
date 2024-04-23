package org.example.repository;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.model.Produto;

import java.util.List;

@Stateless
public class ProdutoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void cadastrarProduto(Produto produto) {
        entityManager.persist(produto);
    }

    @Transactional
    public void atualizarProduto(Produto produto) {
        entityManager.merge(produto);
    }

    public List<Produto> listarTodosProdutos() {
        return entityManager.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
    }

    public Produto listarPorId(Integer id) {
        return entityManager.find(Produto.class, id);
    }

    @Transactional
    public void deletarProduto(Integer id) {
        Produto produto = entityManager.find(Produto.class, id);
        if (produto != null) {
            entityManager.remove(produto);
        }
    }
}
