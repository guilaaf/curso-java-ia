package org.treinamento.javaia.controller;

import org.treinamento.javaia.service.ChatService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/chat")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ChatController {

    @Inject
    ChatService chatService;


    @GET
    public Response info() {
        return Response.ok()
                .entity(new HealthResponse("Chat Service is running", "OK"))
                .build();
    }

    @POST
    public Response chat(ChatRequest request) {
        try {
            String response = chatService.processMessage(request.message());
            return Response.ok()
                    .entity(new ChatResponse(response))
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ErrorResponse("Erro ao processar mensagem: " + e.getMessage()))
                    .build();
        }
    }

    public record ChatRequest(String message) {}
    public record ChatResponse(String response) {}
    public record HealthResponse(String message, String status) {}
    public record ErrorResponse(String error) {}
}
