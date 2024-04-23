package org.example.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.example.model.ItensVenda;
import org.example.repository.ItensVendaRepository;

import java.util.List;

@Stateless
public class ItensVendaService {

    @Inject
    private ItensVendaRepository itensVendaRepository;

    public ItensVenda criarItensVenda(ItensVenda item) {
        return itensVendaRepository.criarItensVenda(item);
    }

    public ItensVenda obterItensVenda(Integer id) {
        return itensVendaRepository.obterItensVenda(id);
    }

    public List<ItensVenda> obterTodosOsItensVenda() {
        return itensVendaRepository.obterTodosOsItensVenda();
    }

    public ItensVenda atualizarItensVenda(ItensVenda item) {
        return itensVendaRepository.atualizarItensVenda(item);
    }

    public boolean deletarItensVenda(Integer id) {
        return itensVendaRepository.deletarItensVenda(id);
    }
}
