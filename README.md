# Task Tracker

Um gerenciador de tarefas simples em Java que salva as tarefas em um arquivo JSON com interface colorida no terminal.

## 🚀 Funcionalidades

- ✅ Adicionar tarefas
- ✅ Atualizar descrição de tarefas
- ✅ Excluir tarefas
- ✅ Marcar tarefas como "em progresso" ou "concluída"
- ✅ Listar todas as tarefas
- ✅ Listar tarefas por status
- 🎨 Interface colorida no terminal
- 📊 Tabela formatada com cores

## 🛠️ Como Usar (com Maven)

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

#### 📝 Exemplos de uso:

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

## 📊 Status Disponíveis

- `TODO` - Tarefa pendente (amarelo)
- `IN_PROGRESS` - Tarefa em progresso (azul)
- `COMPLETED` - Tarefa concluída (verde)

## 🎨 Cores da Interface

- ✅ **Verde**: Mensagens de sucesso
- ❌ **Vermelho**: Mensagens de erro
- ⚠️ **Amarelo**: Avisos e tarefas pendentes
- 📝 **Azul**: Informações e tarefas em progresso
- 🎯 **Roxo**: Títulos e cabeçalhos
- 💡 **Branco brilhante**: IDs das tarefas

## 💾 Arquivo de Dados

As tarefas são salvas no arquivo `tasks.json` na raiz do projeto.

## 🔧 Correções Implementadas

- ✅ Corrigido problema de serialização JSON que causava perda de tarefas
- ✅ Corrigido método `list` para mostrar todas as tarefas
- ✅ Corrigido erro de formatação das datas na tabela
- ✅ JAR gerado já inclui todas as dependências (maven-shade-plugin)
- ✅ Melhor tratamento de erros e robustez
- ✅ Interface colorida para melhor experiência do usuário
- ✅ O nome do JAR agora é sempre `task-tracker.jar` para facilitar a execução

## 🛠️ Tecnologias

- Java 24
- Maven
- Jackson (JSON parsing)
- JSR-310 (Java Time API)
- ANSI Escape Codes (cores no terminal)

## 📋 Pré-requisitos

- Java 24 ou superior
- Maven 3.6 ou superior
- Terminal que suporte cores ANSI (Windows 10+, Linux, macOS)

## 🚀 Exemplo Rápido

```bash
# Compilar
mvn clean package

# Adicionar tarefas
java -jar target/task-tracker.jar add "Estudar Java"
java -jar target/task-tracker.jar add "Fazer exercícios"
java -jar target/task-tracker.jar add "Revisar código"

# Listar todas as tarefas
java -jar target/task-tracker.jar list

# Marcar uma tarefa como concluída
java -jar target/task-tracker.jar mark-done <ID_DA_TAREFA>
```
