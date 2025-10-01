package org.treinamento.javaia.controller;

import org.treinamento.javaia.service.ChatService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/chat")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class ChatController {

    @Inject
    ChatService chatService;


    @GET
    public Response info() {
        return Response.ok()
                .entity("O chat está no ar. Use o método POST para enviar mensagens.")
                .build();
    }

    @POST
    public Response chat(String prompt) {
        try {
            String response = chatService.chat(prompt);
            return Response.ok()
                    .entity(response)
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao processar mensagem: " + e.getMessage())
                    .build();
        }
    }

}
