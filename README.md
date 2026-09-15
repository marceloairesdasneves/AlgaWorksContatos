# 🚀 High-Performance Order Matching Engine (Java 21)

> Um motor de negociação (*Order Matching Engine*) desenvolvido com foco em alta performance, concorrência e modelagem de domínio robusta, utilizando as tecnologias mais modernas do ecossistema Java.

---

## 💡 Sobre o Projeto
Este projeto foi construído como parte de um estudo avançado de engenharia de software e arquitetura de microsserviços. O objetivo é simular o núcleo de um book de ofertas (*Order Book*), processando ordens de compra e venda de forma imutável, segura e com suporte a execuções parciais (*Partial Fills*).

---

## 🛠️ Tecnologias e Recursos Utilizados
* **Java 21**: Linguagem principal, tirando total proveito de recursos modernos.
* **Sealed Interfaces & Records**: Garantia de imutabilidade, modelagem de domínio rica e restrição estrita de tipos (`TradingOrder` permitindo apenas `BuyOrder` e `SellOrder`).
* **Pattern Matching para `switch`**: Código limpo, expressivo e seguro contra falhas de tipo em tempo de execução.
* **Collections & PriorityQueue**: Gerenciamento de filas de alta prioridade ordenadas por melhor preço (maior preço para compra, menor preço para venda).
* **JUnit 5**: Testes unitários rigorosos cobrindo cenários de priorização, cruzamento de preços e execuções parciais.

---

## ⚙️ Arquitetura e Regras de Negócio
* **Imutabilidade de Domínio**: Objetos de valor (`Quantity`, `Money`) e ordens são totalmente imutáveis. Quando ocorre uma execução parcial (*Partial Fill*), um novo objeto residual é gerado e retornado à fila de forma controlada.
* **Segurança de Tipos**: O uso de classes seladas elimina a necessidade de *casts* inseguros ou verificações de instâncias complexas e legadas.

---

## 🧪 Como Executar o Projeto

### Pré-requisitos
* **JDK 21** instalado e configurado na sua IDE (IntelliJ IDEA recomendada).
* **Maven** para gerenciamento de dependências.

### Passos para rodar via terminal:
1. Clone o repositório:
   ```bash
   git clone [https://github.com/SEU-USUARIO/SEU-REPOSITORIO.git](https://github.com/SEU-USUARIO/SEU-REPOSITORIO.git)