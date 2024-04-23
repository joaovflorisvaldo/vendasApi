package org.example.repository;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.Getter;
import org.example.model.Cliente;

@Getter
@Stateless
public class ClienteRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void cadastrar(Cliente cliente) {
        entityManager.persist(cliente);
    }

    public List<Cliente> listarTodosCliente() {
        return entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    }

    public Cliente buscarPorId(Integer id) {
        return entityManager.find(Cliente.class, id);
    }

    @Transactional
    public void deletar(Integer id) {
        Cliente cliente = entityManager.find(Cliente.class, id);
        if (cliente != null) {
            entityManager.remove(cliente);
        }
    }

    @Transactional
    public void salvar(Cliente cliente) {
        entityManager.merge(cliente);
    }

}
