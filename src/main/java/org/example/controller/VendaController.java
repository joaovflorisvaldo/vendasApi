package org.example.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.model.Venda;
import org.example.service.VendaService;

@Path("/vendas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VendaController {

    @Inject
    private VendaService vendaService;

    // Create
    @POST
    public Response criarVenda(Venda venda) {
        Venda novaVenda = vendaService.criarVenda(venda);
        return Response.status(Response.Status.CREATED).entity(novaVenda).build();
    }

    // Read all
    @GET
    public Response listarVendas() {
        return Response.ok(vendaService.listarVendas()).build();
    }

    // Read one
    @GET
    @Path("/{id}")
    public Response encontrarVendaPorId(@PathParam("id") Integer id) {
        Venda venda = vendaService.encontrarVendaPorId(id);
        if (venda != null) {
            return Response.ok(venda).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    // Update
    @PUT
    @Path("/{id}")
    public Response atualizarVenda(@PathParam("id") Integer id, Venda vendaAtualizada) {
        Venda venda = vendaService.atualizarVenda(id, vendaAtualizada);
        if (venda != null) {
            return Response.ok(venda).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    // Delete
    @DELETE
    @Path("/{id}")
    public Response deletarVenda(@PathParam("id") Integer id) {
        boolean deletado = vendaService.deletarVenda(id);
        if (deletado) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}