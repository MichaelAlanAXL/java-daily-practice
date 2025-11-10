# 🧩 Day 27 - Chat com histórico limitado (`Queue`)

Este projeto faz parte do desafio **"30 Dias de Java"**, e o foco deste dia é entender e aplicar o conceito de **filas (`Queue`)** em Java.
Foram desenvolvidos **4 exemplos** em ordem de complexidade, para compreender desde o uso básico até aplicações reais.

---

## 📚 Conceito
Uma **fila (Queue)** é uma estrutura de dados do tipo **FIFO** (*First In, First Out*) — ou seja, o primeiro elemento a entrar é o primeiro a sair.  
Ela é amplamente utilizada em sistemas reais, como:
- Processamento de pedidos
- Histórico de chats
- Logs de sistemas
- Filas de mensagens e eventos

---

## 🧠 Exemplos implementados

### 1️⃣ `ExemploBasicoFila.java`
Fila simples usando `LinkedList`.  
Mostra como adicionar, visualizar e remover elementos em ordem FIFO.

**Funcionalidades:**
- Adiciona 3 clientes na fila.
- Remove o primeiro (atendido).
- Exibe o próximo sem remover.

🟢 **Executar:** basta rodar este arquivo individualmente.

---

### 2️⃣ `FilaLimitada.java`
Implementa uma **fila com tamanho máximo**.  
Quando o limite é atingido, o item mais antigo é removido automaticamente.

**Funcionalidades:**
- Adiciona mensagens.
- Mantém somente as últimas 3 no histórico.

🟢 **Executar:** cada execução adiciona mensagens e mostra o comportamento de remoção automática.

---

### 3️⃣ `MiniChat` (pasta com `Main.java`, `ChatService.java`, `Mensagem.java`)
Simula um **chat local com histórico limitado**, armazenando apenas as 5 últimas mensagens.

**Pacotes usados:**
- `model.Mensagem` → Define estrutura da mensagem (autor, conteúdo, horário).  
- `service.ChatService` → Controla o envio e histórico das mensagens.  
- `Main.java` → Interface simples via terminal para testar o chat.

**Funcionalidades:**
- Enviar mensagens.
- Visualizar histórico (máximo de 5).
- Histórico atualizado automaticamente (o mais antigo é removido).

🟢 **Executar:** rode o arquivo `Main.java`.

---

### 4️⃣ `FilaPedidos.java`
Exemplo mais próximo do mundo real: **fila de processamento de pedidos**.

**Recursos usados:**
- `ConcurrentLinkedQueue` → fila segura para múltiplas threads.  
- Threads para simular o processamento de pedidos em tempo real.

**Funcionalidades:**
- Recebe pedidos.
- Processa em paralelo.
- Exibe logs durante o processamento.

🟢 **Executar:** rode o arquivo `FilaPedidos.java` para ver a simulação.

---

## 🧩 Conceitos importantes revisados

| Conceito | Explicação |
|-----------|------------|
| `Queue` | Estrutura FIFO (First In, First Out) |
| `LinkedList` | Implementação simples e flexível de fila |
| `poll()` | Remove o primeiro elemento da fila |
| `peek()` | Visualiza o primeiro elemento sem remover |
| `ConcurrentLinkedQueue` | Fila thread-safe para sistemas com múltiplas threads |
| Histórico limitado | Aplicação prática para chats, logs e caches |

---

## 🏁 Conclusão
Neste dia foi possível:
- Entender o comportamento das filas em Java.
- Implementar diferentes cenários (simples e complexos).
- Relacionar conceitos de estruturas de dados com aplicações reais.

O conceito de **fila (`Queue`)** é uma base sólida que aparece em praticamente todo sistema que trabalha com **processamento assíncrono, mensagens ou histórico limitado.**

---

✍️ *Desenvolvido por Michael Alan — Day 27 do Desafio 30 Dias de Java.* 