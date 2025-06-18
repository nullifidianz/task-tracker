# Task Tracker

Um gerenciador de tarefas simples em Java que salva as tarefas em um arquivo JSON.

## Funcionalidades

- ✅ Adicionar tarefas
- ✅ Atualizar descrição de tarefas
- ✅ Excluir tarefas
- ✅ Marcar tarefas como "em progresso" ou "concluída"
- ✅ Listar todas as tarefas
- ✅ Listar tarefas por status

## Como Usar (com Maven)

### 1. Compilar e empacotar o projeto

Gere um JAR "fat" (com todas as dependências) usando:

```bash
mvn clean package
```

O arquivo gerado estará em `target/task-tracker.jar`.

### 2. Executar comandos

Execute o JAR usando:

```bash
java -jar target/task-tracker.jar <comando>
```

#### Exemplos de uso:

- **Adicionar tarefa:**
  ```bash
  java -jar target/task-tracker.jar add "Descrição da tarefa"
  ```
- **Atualizar tarefa:**
  ```bash
  java -jar target/task-tracker.jar update <ID_DA_TAREFA> "Nova descrição"
  ```
- **Excluir tarefa:**
  ```bash
  java -jar target/task-tracker.jar delete <ID_DA_TAREFA>
  ```
- **Marcar como em progresso:**
  ```bash
  java -jar target/task-tracker.jar mark-in-progress <ID_DA_TAREFA>
  ```
- **Marcar como concluída:**
  ```bash
  java -jar target/task-tracker.jar mark-done <ID_DA_TAREFA>
  ```
- **Listar todas as tarefas:**
  ```bash
  java -jar target/task-tracker.jar list
  ```
- **Listar tarefas por status:**
  ```bash
  java -jar target/task-tracker.jar list todo
  java -jar target/task-tracker.jar list in-progress
  java -jar target/task-tracker.jar list done
  ```

## Status Disponíveis

- `TODO` - Tarefa pendente
- `IN_PROGRESS` - Tarefa em progresso
- `COMPLETED` - Tarefa concluída

## Arquivo de Dados

As tarefas são salvas no arquivo `tasks.json` na raiz do projeto.

## Tecnologias

- Java 24
- Maven
- Jackson (JSON parsing)
- JSR-310 (Java Time API)
