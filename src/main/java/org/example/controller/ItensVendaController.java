package org.example.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.model.ItensVenda;
import org.example.service.ItensVendaService;

import java.util.List;

@Path("/itens-venda")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItensVendaController {

    @Inject
    private ItensVendaService itensVendaService;

    @POST
    public Response criarItensVenda(ItensVenda item) {
        ItensVenda newItem = itensVendaService.criarItensVenda(item);
        return Response.ok(newItem).build();
    }

    @GET
    @Path("/{id}")
    public Response obterItensVenda(@PathParam("id") Integer id) {
        ItensVenda item = itensVendaService.obterItensVenda(id);
        if (item != null) {
            return Response.ok(item).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    public Response obterTodosOsItensVenda() {
        List<ItensVenda> itensVendaList = itensVendaService.obterTodosOsItensVenda();
        return Response.ok(itensVendaList).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizarItensVenda(@PathParam("id") Integer id, ItensVenda item) {
        item.setId(id); // Garante que o ID seja o correto
        ItensVenda updatedItem = itensVendaService.atualizarItensVenda(item);
        if (updatedItem != null) {
            return Response.ok(updatedItem).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deletarItensVenda(@PathParam("id") Integer id) {
        boolean deleted = itensVendaService.deletarItensVenda(id);
        if (deleted) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
