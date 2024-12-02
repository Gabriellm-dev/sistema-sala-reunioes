# Sistema de Reservas de Salas de Reunião

Este projeto é um sistema de gerenciamento de reservas de salas de reunião desenvolvido em Java e utilizando MongoDB como banco de dados. O sistema permite o gerenciamento de salas e reservas, incluindo a criação, atualização, e exclusão de salas e reservas, além de validações de disponibilidade e recursos.

## Funcionalidades

- **Gerenciamento de Salas**: Criação, atualização e exclusão de salas de reunião com capacidade, recursos e status de ativação.
- **Reserva de Salas**: Permite reservar salas para horários específicos, respeitando a disponibilidade e o status de ativação.
- **Gerenciamento de Reservas**: Visualização, alteração e cancelamento de reservas.
- **Validações**: Verificação de conflitos de horário e disponibilidade de recursos.
- **Filtros de Busca**: Permite buscar salas disponíveis com base em data, capacidade e recursos desejados.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3**
- **MongoDB**
- **Docker**
- **Padrões de Design**
- **Maven**

## Requisitos

- Java 17+
- MongoDB
- Docker e Docker Compose (para ambiente de execução)
- Maven (para build e gerenciamento de dependências)

## Instalação

1. Clone o repositório:

   ```bash
   git clone https://github.com/gabriellm-dev/sistema-salas-reunioes.git
   cd sistema-salas-reunioes
   ```

2. Configure o MongoDB:

   - Verifique se o MongoDB está instalado e em execução na porta `27017`.
   - Se preferir, use o Docker Compose para configurar o MongoDB:

     ```bash
     docker-compose up -d
     ```

3. Configure o ambiente de desenvolvimento com Maven:

   ```bash
   mvn clean install
   ```

4. Execute a aplicação:

   ```bash
   mvn spring-boot:run
   ```

## Endpoints

Abaixo estão os principais endpoints disponíveis no sistema.

### Salas

- **POST /salas** - Cria uma nova sala.
  - Exemplo de requisição:

    ```json
    {
      "nome": "Sala de Reunião 1",
      "capacidade": 10,
      "recursos": ["Projetor", "Pizarra", "Wi-Fi"]
    }
    ```

- **GET /salas** - Lista todas as salas.
- **GET /salas/{id}** - Retorna uma sala específica pelo ID.
- **PUT /salas/{id}** - Atualiza as informações de uma sala existente.
- **DELETE /salas/{id}** - Exclui uma sala pelo ID.

### Reservas

- **POST /reservas** - Cria uma nova reserva para uma sala.
  - Exemplo de requisição:

    ```json
    {
      "usuario": "João Silva",
      "dataInicio": "2024-11-15T10:00:00",
      "dataFim": "2024-11-15T12:00:00",
      "salaId": "64f8a5c7e4b0d5e9c1234567"
    }
    ```

- **GET /reservas** - Lista todas as reservas.
- **GET /reservas/{id}** - Retorna uma reserva específica pelo ID.
- **PUT /reservas/{id}** - Atualiza uma reserva existente.
- **DELETE /reservas/{id}** - Cancela uma reserva pelo ID.

## Exemplos de Uso

### Criando uma Sala

```bash
curl -X POST http://localhost:8080/salas -H "Content-Type: application/json" -d '{
  "nome": "Sala de Reunião 1",
  "capacidade": 10,
  "recursos": ["Projetor", "Pizarra", "Wi-Fi"]
}'
```

### Reservando uma Sala

```bash
curl -X POST http://localhost:8080/reservas -H "Content-Type: application/json" -d '{
  "usuario": "João Silva",
  "dataInicio": "2024-11-15T10:00:00",
  "dataFim": "2024-11-15T12:00:00",
  "salaId": "64f8a5c7e4b0d5e9c1234567"
}'
```

## Testes

O projeto inclui uma cobertura mínima de testes para validações e operações de CRUD. Para executar os testes:

```bash
mvn test
```

## Executando com Docker

Para rodar a aplicação com Docker, execute o comando abaixo, que usará o `Dockerfile` e o `docker-compose.yml` para configurar o MongoDB e a aplicação:

```bash
docker-compose up --build
```
