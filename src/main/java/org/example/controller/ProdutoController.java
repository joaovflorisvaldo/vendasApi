package org.example.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.model.Produto;
import org.example.service.ProdutoService;

import java.util.List;

@Path("/estante")
public class ProdutoController {
    @Inject
    private ProdutoService produtoService;

    // Listar todos os produtos
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listarProdutos() {
        List<Produto> produtos = produtoService.listar();
        return Response.ok(produtos).build();
    }

    // Obter um produto por ID
    @GET
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response obterProduto(@PathParam("id") Integer id) {
        Produto produto = produtoService.obterPorId(id);
        if (produto != null) {
            return Response.ok(produto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    // Criar um novo produto
    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response criarProduto(Produto produto) {
        produtoService.salvar(produto);
        return Response.status(Response.Status.CREATED).build();
    }

    // Atualizar um produto existente
    @PUT
    @Path("/{id}")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response atualizarProduto(@PathParam("id") Integer id, Produto produto) {
        Produto produtoExistente = produtoService.obterPorId(id);
        if (produtoExistente != null) {
            produto.getId();
            produtoService.atualizar(produto);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    // Deletar um produto
    @DELETE
    @Path("/{id}")
    public Response deletarProduto(@PathParam("id") Integer id) {
        Produto produto = produtoService.obterPorId(id);
        if (produto != null) {
            produtoService.deletar(id);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
