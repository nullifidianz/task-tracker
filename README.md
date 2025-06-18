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

O arquivo gerado estará em `target/task-tracker-1.0-SNAPSHOT.jar` (ou `task-tracker-1.0-SNAPSHOT-shaded.jar`).

### 2. Executar comandos

Execute o JAR usando:

```bash
java -jar target/task-tracker-1.0-SNAPSHOT.jar <comando>
```

#### Exemplos de uso:

- **Adicionar tarefa:**
  ```bash
  java -jar target/task-tracker-1.0-SNAPSHOT.jar add "Descrição da tarefa"
  ```
- **Atualizar tarefa:**
  ```bash
  java -jar target/task-tracker-1.0-SNAPSHOT.jar update <ID_DA_TAREFA> "Nova descrição"
  ```
- **Excluir tarefa:**
  ```bash
  java -jar target/task-tracker-1.0-SNAPSHOT.jar delete <ID_DA_TAREFA>
  ```
- **Marcar como em progresso:**
  ```bash
  java -jar target/task-tracker-1.0-SNAPSHOT.jar mark-in-progress <ID_DA_TAREFA>
  ```
- **Marcar como concluída:**
  ```bash
  java -jar target/task-tracker-1.0-SNAPSHOT.jar mark-done <ID_DA_TAREFA>
  ```
- **Listar todas as tarefas:**
  ```bash
  java -jar target/task-tracker-1.0-SNAPSHOT.jar list
  ```
- **Listar tarefas por status:**
  ```bash
  java -jar target/task-tracker-1.0-SNAPSHOT.jar list todo
  java -jar target/task-tracker-1.0-SNAPSHOT.jar list in-progress
  java -jar target/task-tracker-1.0-SNAPSHOT.jar list done
  ```

## Status Disponíveis

- `TODO` - Tarefa pendente
- `IN_PROGRESS` - Tarefa em progresso
- `COMPLETED` - Tarefa concluída

## Arquivo de Dados

As tarefas são salvas no arquivo `tasks.json` na raiz do projeto.

## Correções Implementadas

- Corrigido problema de serialização JSON que causava perda de tarefas
- Corrigido método `list` para mostrar todas as tarefas
- Corrigido erro de formatação das datas na tabela
- JAR gerado já inclui todas as dependências (maven-shade-plugin)
- Melhor tratamento de erros e robustez

## Tecnologias

- Java 24
- Maven
- Jackson (JSON parsing)
- JSR-310 (Java Time API)
