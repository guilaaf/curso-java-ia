package org.treinamento.javaia.service;

import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
public interface ChatService {

    String chat(String prompt);
}
