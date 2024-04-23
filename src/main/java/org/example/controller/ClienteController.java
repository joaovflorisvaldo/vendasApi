package org.example.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.model.Cliente;
import org.example.service.ClienteService;

@Path("/cliente")
public class ClienteController {

    @Inject
    private ClienteService clienteService;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listarClientes() {
        try {
            return Response.ok(clienteService.listar()).build();
        } catch (Exception ex) {
            return Response.status(500).entity("Erro ao listar clientes").build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response buscarClientePorId(@PathParam("id") Integer id) {
        try {
            Cliente cliente = clienteService.buscarPorId(id);
            if (cliente != null) {
                return Response.ok(cliente).build();
            } else {
                return Response.status(404).entity("Cliente não encontrado").build();
            }
        } catch (Exception ex) {
            return Response.status(500).entity("Erro ao buscar cliente").build();
        }
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response criarCliente(Cliente cliente) {
        try {
            clienteService.criar(cliente);
            return Response.status(201).entity("Cliente criado com sucesso").build();
        } catch (Exception ex) {
            return Response.status(500).entity("Erro ao criar cliente").build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response atualizarCliente(@PathParam("id") Integer id, Cliente clienteAtualizado) {
        try {
            clienteAtualizado.setId(id);
            clienteService.atualizar(clienteAtualizado);
            return Response.status(200).entity("Cliente atualizado com sucesso").build();
        } catch (Exception ex) {
            return Response.status(500).entity("Erro ao atualizar cliente").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deletarCliente(@PathParam("id") Integer id) {
        try {
            clienteService.deletar(id);
            return Response.status(204).entity("Cliente deletado com sucesso").build();
        } catch (Exception ex) {
            return Response.status(500).entity("Erro ao deletar cliente").build();
        }
    }
}
