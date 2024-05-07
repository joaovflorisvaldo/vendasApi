package org.example.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.example.model.Venda;
import org.example.repository.VendaRepository;
import java.util.*;

@Stateless
public class VendaService {

    @Inject
    private VendaRepository vendaRepository;

    public Venda criarVenda(Venda venda) {
        return vendaRepository.salvarVenda(venda);
    }

    public List<Venda> listarVendas() {
        return vendaRepository.listarTodasVendas();
    }

    public Venda encontrarVendaPorId(Integer id) {
        Optional<Venda> vendaOptional = vendaRepository.listarPorId(id);
        return vendaOptional.orElse(null);
    }

    public List<Venda> relatorioVenda() {
        return vendaRepository.relatorioVenda();
    }

    public List<Venda> relatorioCliente(){
        return vendaRepository.relatorioCliente();
    }

    public Venda atualizarVenda(Integer id, Venda vendaAtualizada) {
        Optional<Venda> vendaOptional = vendaRepository.listarPorId(id);
        if (vendaOptional.isPresent()) {
            Venda venda = vendaOptional.get();
            venda.setTitulo(vendaAtualizada.getTitulo());
            venda.setTotal(vendaAtualizada.getTotal());
            venda.setObservacoes(vendaAtualizada.getObservacoes());
            venda.setCliente(vendaAtualizada.getCliente());
            venda.setListaItens(vendaAtualizada.getListaItens());
            return vendaRepository.atualizarVenda(venda);
        } else {
            return null;
        }
    }

    public boolean deletarVenda(Integer id) {
        Optional<Venda> vendaOptional = vendaRepository.listarPorId(id);
        if (vendaOptional.isPresent()) {
            vendaRepository.deletarVenda(vendaOptional.get());
            return true;
        } else {
            return false;
        }
    }
}
