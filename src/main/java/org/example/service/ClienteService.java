package org.example.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.example.model.Cliente;
import org.example.repository.ClienteRepository;

import java.util.List;

@Stateless
public class ClienteService {

    @Inject
    private ClienteRepository clienteRepository;

    public List<Cliente> listar() {
        return clienteRepository.listarTodosCliente();
    }

    public Cliente buscarPorId(Integer id) {
        return clienteRepository.buscarPorId(id);
    }

    public void criar(Cliente cliente) throws Exception {
        clienteRepository.cadastrar(cliente);
    }

    public void atualizar(Cliente cliente) throws Exception {
        clienteRepository.salvar(cliente);
    }

    public void deletar(Integer id) throws Exception {
        clienteRepository.deletar(id);
    }
}
