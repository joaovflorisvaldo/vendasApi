package org.example.repository;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.model.Venda;

import java.util.List;
import java.util.Optional;

@Stateless
public class VendaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Venda salvarVenda(Venda venda) {
        entityManager.persist(venda);
        return venda;
    }

    public List<Venda> listarTodasVendas() {
        return entityManager.createQuery("SELECT v FROM Venda v", Venda.class).getResultList();
    }

    public Optional<Venda> listarPorId(Integer id) {
        Venda venda = entityManager.find(Venda.class, id);
        return Optional.ofNullable(venda);
    }

    public Venda atualizarVenda(Venda venda) {
        return entityManager.merge(venda);
    }

    public void deletarVenda(Venda venda) {
        entityManager.remove(entityManager.contains(venda) ? venda : entityManager.merge(venda));
    }

    public List<Venda> relatorioVenda() {
        List<Venda> result = entityManager.createQuery(
                        "SELECT v, c.id, SUM(v.total), c.nome " +
                                "FROM Venda v " +
                                "JOIN v.cliente c " +
                                "GROUP BY v, c.id, c.nome", Venda.class).getResultList();

        return result;
    }

    public List<Venda> relatorioCliente(){
        List<Venda> result = entityManager.createQuery(
                "SELECT c.id, c.nome, COUNT(v) " +
                        "FROM Venda v " +
                        "JOIN v.cliente c " +
                        "GROUP BY c.id, c.nome", Venda.class)
                .getResultList();

        return result;
    }


}
