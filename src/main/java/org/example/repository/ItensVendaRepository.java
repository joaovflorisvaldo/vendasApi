package org.example.repository;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.model.ItensVenda;

import java.util.List;

@Stateless
public class ItensVendaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public ItensVenda criarItensVenda(ItensVenda item) {
        entityManager.persist(item);
        return item;
    }

    public ItensVenda obterItensVenda(Integer id) {
        return entityManager.find(ItensVenda.class, id);
    }

    public List<ItensVenda> obterTodosOsItensVenda() {
        return entityManager.createQuery("SELECT i FROM ItensVenda i", ItensVenda.class).getResultList();
    }

    @Transactional
    public ItensVenda atualizarItensVenda(ItensVenda item) {
        return entityManager.merge(item);
    }

    @Transactional
    public boolean deletarItensVenda(Integer id) {
        ItensVenda item = entityManager.find(ItensVenda.class, id);
        if (item != null) {
            entityManager.remove(item);
            return true;
        } else {
            return false;
        }
    }
}
