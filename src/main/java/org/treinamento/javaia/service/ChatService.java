package org.treinamento.javaia.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class ChatService {

    private static final Logger LOG = LoggerFactory.getLogger(ChatService.class);

    @ConfigProperty(name = "ai.default.response", defaultValue = "Olá! Sou um assistente de IA integrado ao Quarkus.")
    String defaultResponse;

    @ConfigProperty(name = "ai.enabled", defaultValue = "true")
    boolean aiEnabled;

    public String processMessage(String message) {
        LOG.info("Processando mensagem: {}", message);

        if (!aiEnabled) {
            return "Serviço de IA está desabilitado.";
        }

        if (message == null || message.trim().isEmpty()) {
            return "Por favor, envie uma mensagem válida.";
        }

        // Simulação de processamento de IA
        // Em um cenário real, aqui você integraria com LangChain4j
        return String.format("%s Você disse: '%s'", defaultResponse, message);
    }
}
