# Curso Java com IA - Quarkus Edition

Este projeto foi migrado para usar **Quarkus 3.17.3** com as melhores práticas de desenvolvimento, incluindo integração com LangChain4j para funcionalidades de IA.

## 🚀 Tecnologias Utilizadas

- **Java 21** - Versão LTS mais recente
- **Quarkus 3.17.3** - Framework supersônico e subatômico
- **LangChain4j** - Biblioteca para integração com IA
- **JAX-RS (RESTEasy Reactive)** - APIs REST reativas
- **CDI/Arc** - Injeção de dependências
- **MicroProfile** - Health checks, métricas e OpenAPI
- **JUnit 5** - Testes automatizados
- **Docker** - Containerização

## 📋 Pré-requisitos

- Java 21 ou superior
- Maven 3.8+
- Docker (opcional)

## 🛠️ Como Executar

### Modo Desenvolvimento
```bash
./mvnw quarkus:dev
```

### Modo Produção
```bash
./mvnw clean package
java -jar target/quarkus-app/quarkus-run.jar
```

### Com Docker
```bash
./mvnw clean package
docker build -f src/main/docker/Dockerfile.jvm -t quarkus/curso-java-ia .
docker run -i --rm -p 8080:8080 quarkus/curso-java-ia
```

### Docker Compose (com monitoramento)
```bash
docker-compose up -d
```

## 🔗 Endpoints Disponíveis

### API Principal
- `GET /ai/health` - Status do serviço de IA
- `POST /ai/chat` - Chat com IA

### Monitoramento e Documentação
- `GET /q/health` - Health checks
- `GET /q/health/ready` - Readiness check
- `GET /q/health/live` - Liveness check
- `GET /q/metrics` - Métricas Prometheus
- `GET /q/swagger-ui` - Documentação da API
- `GET /q/openapi` - Especificação OpenAPI

### Exemplo de Uso da API

```bash
# Verificar status
curl http://localhost:8080/ai/health

# Enviar mensagem para o chat
curl -X POST http://localhost:8080/ai/chat \
  -H "Content-Type: application/json" \
  -d '{"message": "Olá, como você está?"}'
```

## 🧪 Executar Testes

```bash
# Testes unitários
./mvnw test

# Testes de integração
./mvnw verify
```

## 📊 Monitoramento

O projeto inclui integração completa com:

- **Prometheus** - Coleta de métricas (http://localhost:9090)
- **Grafana** - Visualização de métricas (http://localhost:3000)
  - Usuário: `admin`
  - Senha: `admin`

## ⚙️ Configuração

### Arquivo de Configuração
As configurações estão em `src/main/resources/application.yml`:

```yaml
quarkus:
  application:
    name: curso-java-ia
  http:
    port: 8080

ai:
  enabled: true
  default:
    response: "Olá! Sou um assistente de IA integrado ao Quarkus."
```

### Variáveis de Ambiente
- `OPENAI_API_KEY` - Chave da API OpenAI (opcional)
- `QUARKUS_PROFILE` - Profile de execução (dev, test, prod)

## 🏗️ Arquitetura

```
src/
├── main/
│   ├── java/
│   │   └── org/treinamento/javaia/
│   │       ├── Application.java              # Classe principal
│   │       ├── controller/
│   │       │   └── AIController.java         # Controlador REST
│   │       ├── service/
│   │       │   └── AIService.java            # Lógica de negócio
│   │       └── health/
│   │           └── AIServiceHealthCheck.java # Health checks
│   ├── resources/
│   │   └── application.yml                   # Configurações
│   └── docker/
│       ├── Dockerfile.jvm                    # Container JVM
│       └── Dockerfile.native                 # Container nativo
└── test/
    └── java/
        └── org/treinamento/javaia/
            └── AIControllerTest.java          # Testes
```

## 🚀 Build Nativo (GraalVM)

Para máxima performance, compile para nativo:

```bash
./mvnw clean package -Dnative
```

**Requisitos:**
- GraalVM 21
- Native Image instalado

## 📝 Melhores Práticas Implementadas

✅ **Injeção de Dependências** com CDI/Arc  
✅ **Configuração Externa** com MicroProfile Config  
✅ **Health Checks** para monitoramento  
✅ **Métricas** com Micrometer/Prometheus  
✅ **Documentação da API** com OpenAPI  
✅ **Testes Automatizados** com JUnit 5  
✅ **Containerização** com Docker  
✅ **Profiles** para diferentes ambientes  
✅ **Logging** estruturado  
✅ **Monitoramento** com Prometheus/Grafana  

## 🔧 Desenvolvimento

### Hot Reload
O Quarkus suporta hot reload automático em modo dev:
```bash
./mvnw quarkus:dev
```

### Debug
Para debug, adicione:
```bash
./mvnw quarkus:dev -Ddebug=5005
```

## 📚 Recursos Adicionais

- [Quarkus Documentation](https://quarkus.io/guides/)
- [LangChain4j Quarkus Extension](https://docs.quarkiverse.io/quarkus-langchain4j/dev/)
- [MicroProfile Specifications](https://microprofile.io/)

## 🤝 Contribuição

1. Fork o projeto
2. Crie uma branch para sua feature
3. Commit suas mudanças
4. Push para a branch
5. Abra um Pull Request

---

**Nota:** Este projeto utiliza o repositório Maven da Petrobras configurado no `pom.xml` para resolução de dependências corporativas.
