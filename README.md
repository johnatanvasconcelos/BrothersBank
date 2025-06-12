# 🏥 BrothersBank API

## Visão geral do Projeto:
> **Descrição**: Aplicação bancária fictícia com contas corrente e poupança, operações financeiras, validações de dados de entrada, usuários e permissões.

>**Objetivo**: Estudar e demonstrar conceitos de orientação a objetos, API REST, arquitetura MVC, validações de dados, versionamento de banco de dados, SRP, boas práticas, segurança e persistência de dados.

---

### ✨ Funcionalidades Principais

- 👨‍⚕️ **Gestão de Contas**: CRUD completo com tipos de contas
- 📅 **Operações bancárias**: Sistema de operações típicas de bancos
- 📊 **Relatórios**: Listagem de contas por status ou tipos.
- 🚧 **Mais funcionalidades a caminho...**

## 🛠️ Tecnologias Utilizadas

- **Java 17** - Linguagem principal
- **Spring Boot 3.x** - Framework principal
- **Spring Data JPA** - Persistência de dados
- **Flyway** - Controle de versão do banco
- **PostgreSQL** - Banco de dados
- **Bean Validation** - Validação de dados
- **Maven** - Gerenciamento de dependências
- **Postman** - Teste de API
- **Swagger/OpenAPI** - Documentação da API


## 🚀 Como Executar

### Pré-requisitos

- Java 17 ou superior
- Maven 3.6+
- PostgreSQL (opcional - usar H2 para desenvolvimento)

### Passo a Passo

1. ***Clone o repositório***
```bash
git clone https://github.com/johnatanvasconcelos/BrothersBank.git
cd BrothersBank
```

2. ***Configure o banco de dados***
```properties
# application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/brothersbank
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

3. ***Execute a aplicação***
```bash
mvn spring-boot:run
```

4. *Acesse a documentação*
: ***Após iniciar a aplicação, acesse pelo navegador, os links abaixo para ler a documentação da API***

- Swagger UI: http://localhost:8080/swagger-ui.html
- API Docs: http://localhost:8080/v3/api-docs

## 📁 Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── br/
│   │       └── com/
│   │           └── john/
│   │               └── brothersbank/
│   │                   ├── config/
│   │                   │   ├── BooleanToStringConverter/
│   │                   ├── controller/
│   │                   │   ├── AccountController/
│   │                   ├── exception/
│   │                   │   ├── InsufficientFundsException/
│   │                   ├── models/
│   │                   │   ├── account/
│   │                   │   │    ├── dto/
│   │                   │   │    │     ├── AccountDetailsDTO/
│   │                   │   │    │     ├── AccountRequestDTO/
│   │                   │   │    ├── entity/
│   │                   │   │    │     ├── Account/
│   │                   │   │    │     ├── AccountStatus/
│   │                   │   │    │     ├── AccountType/
│   │                   │   │    ├── repository/
│   │                   │   │    │     ├── AccountRepository/
│   │                   │   │    ├── service/
│   │                   │   │    │     ├── AccountService/
│   │                   │   ├── checking/
│   │                   │   │    ├── dto/
│   │                   │   │    │     ├── CheckingAccountRequestDTO/
│   │                   │   │    │     ├── CheckingAccountResponseDTO/
│   │                   │   │    │     ├── CheckingAccountUpdateDTO/
│   │                   │   │    ├── entity/
│   │                   │   │    │     ├── CheckingAccount/
│   │                   │   │    ├── mapper/
│   │                   │   │    │     ├── CheckingAccountMapper/
│   │                   │   │    ├── repository/
│   │                   │   │    │     ├── CheckingAccountRepository/
│   │                   │   │    ├── service/
│   │                   │   │    │     ├── CheckingAccountService/
│   │                   │   ├── savings/
│   │                   │   │    ├── dto/
│   │                   │   │    │     ├── SavingsAccountRequestDTO/
│   │                   │   │    │     ├── SavingsAccountResponseDTO/
│   │                   │   │    │     ├── SavingsAccountUpdateDTO/
│   │                   │   │    ├── entity/
│   │                   │   │    │     ├── SavingsAccount/
│   │                   │   │    ├── mapper/
│   │                   │   │    │     ├── SavingsAccountMapper/
│   │                   │   │    ├── repository/
│   │                   │   │    │     ├── SavingsAccountRepository/
│   │                   │   │    ├── service/
│   │                   │   │    │     ├── SavingsAccountService/
│   │                   └── BrothersbankApplication.java
│   └── resources/
│       ├── application.properties               # Configurações da aplicação
│       └── db/migration/                        # Scripts Flyway
└── test/
    └── java/
        └── br/
            └── com/
                └── john/
                    └── brothersbank/
                           ├──BrothersbankApplicationTests
```

## 🏗️ Arquitetura do Projeto

> O projeto segue os princípios de **arquitetura em camadas** com **separação por domínio de negócio**
> 
### Principais Padrões Implementados

* **Inheritance Pattern** - Herança entre Account, CheckingAccount e SavingsAccount
* **Repository Pattern** - Abstração de acesso a dados com Spring Data JPA
* **DTO Pattern** - Separação completa entre DTOs de Request, Response e Update
* **Mapper Pattern** - Conversão limpa entre entidades e DTOs usando mappers dedicados
* **Exception Handling** - Exceções customizadas para regras de negócio bancário
* **Converter Pattern** - Conversores JPA para transformações de dados
* **Service Layer Pattern** - Lógica de negócio isolada em serviços especializados

### Organização por Domínio Bancário

A estrutura reflete operações bancárias reais com separação clara:

- **Hierarquia de Contas** com Account como classe base abstrata
- **Especialização por Tipo** - Checking e Savings com suas particularidades
- **DTOs Especializados** para cada operação e tipo de conta
- **Mappers Dedicados** para conversões limpas entre camadas
- **Repositórios Específicos** para cada tipo de conta
- **Serviços Especializados** com regras de negócio próprias de cada tipo


### Endpoints
- `POST /api/accounts/checking` - Abrir uma conta-corrente
- `POST /api/accounts/savings` - Abrir uma conta poupança
- `GET /api/accounts/{id}` - Listar detalhes de uma conta
- `PUT /api/accounts/` - Listar todas as contas
- `DELETE /api/accounts/checking/{id}` - Atualizar dados de uma conta-corrente
- `DELETE /api/accounts/savings/{id}` - Atualizar dados de uma conta poupança
- `DELETE /api/accounts/{id}` - Deletar uma conta (Tornar inativa)

[//]: # ()
[//]: # (## 📋 Validações Implementadas)

[//]: # ()
[//]: # (- ✅ Validação de email único)

[//]: # (## 🔧 Configurações Adicionais)

[//]: # ()
[//]: # (### Profiles)

[//]: # (- `dev` - Desenvolvimento &#40;H2 database&#41;)

[//]: # (- `prod` - Produção &#40;MySQL&#41;)

[//]: # (- `test` - Testes &#40;H2 in-memory&#41;)

[//]: # ()
[//]: # (### Variáveis de Ambiente)

[//]: # (```bash)

[//]: # (# JWT)

[//]: # (JWT_SECRET=sua_chave_secreta_jwt)

[//]: # (JWT_EXPIRATION=86400000)

[//]: # ()
[//]: # (# Database)

[//]: # (DB_URL=jdbc:mysql://localhost:3306/cleanmed)

[//]: # (DB_USER=usuario)

[//]: # (DB_PASSWORD=senha)

[//]: # (```)
[//]: # ()

## 🤝 Contribuindo

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nome-da-feature`)
3. Commit suas mudanças (`git commit -m 'feat: adiciona nova funcionalidade'`)
4. Push para a branch (`git push origin feature/nome-da-feature`)
5. Abra um Pull Request

## 📄 Licença
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 👨‍💻 Autor

**Johnatan Vasconcelos**
- LinkedIn: [Johnatan Vasconcelos](https://www.linkedin.com/in/johnatan-vasconcelos)
- GitHub: [@johnatanvasconcelos](https://github.com/johnatanvasconcelos)

---

⭐ Se este projeto foi útil para você, considere dar uma estrela!

## 🔄 Próximas Implementações

- [ ] Criar mais tratamento de exceções
- [ ] Padrões de segurança com Spring Security
- [ ] Autenticação com JWT
- [ ] Testes Unitários