# curso-java-ia

Esqueleto de projeto Maven com Java 25 e LangChain4j.

## Requisitos
- JDK 25 instalado e configurado no PATH (ou via JAVA_HOME)
- Maven 3.9+

## Estrutura
- `pom.xml` configurado com `maven-compiler-plugin` usando `release=25`
- Dependência `dev.langchain4j:langchain4j`
- Código exemplo em `src\\main\\java\\com\\example\\App.java`
- Teste básico em `src\\test\\java\\com\\example\\AppTest.java`

## Como usar
1. Compilar e rodar testes:
   - `mvn clean verify`
2. Construir o JAR:
   - `mvn package`
3. Executar a aplicação (se adicionar o plugin exec do Maven):
   - Adicione ao `pom.xml` (exemplo):

     ```xml
     <plugin>
       <groupId>org.codehaus.mojo</groupId>
       <artifactId>exec-maven-plugin</artifactId>
       <version>3.1.0</version>
       <configuration>
         <mainClass>org.treinamento.javaia.Apporg.treinamento.javaia.App</mainClass>
       </configuration>
     </plugin>
     ```
   - Depois rode: `mvn exec:java`

## Observações
- Para usar um provedor específico (ex.: OpenAI, Azure OpenAI, Ollama, etc.), inclua o artefato correspondente do LangChain4j (por exemplo, `langchain4j-open-ai`) e configure as credenciais via variáveis de ambiente.
- As versões das dependências podem ser ajustadas conforme necessário.