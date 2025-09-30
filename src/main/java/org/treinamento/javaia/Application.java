package org.treinamento.javaia;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class Application implements QuarkusApplication {

    @Override
    public int run(String... args) throws Exception {
        System.out.println("Projeto Quarkus com Java e LangChain4j iniciado!");
        Quarkus.waitForExit();
        return 0;
    }

    public static void main(String... args) {
        Quarkus.run(Application.class, args);
    }
}
