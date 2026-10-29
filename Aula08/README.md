# Aula 8 — Listas

Exemplos e exercícios para acompanhar a Aula 8: criar listas com `listOf`, aceder aos elementos
(`[i]`, `size`, `indices`, `first`, `last`), percorrer com `for`, os operadores `+`, `-` e `in`,
e as funções `forEach`, `filter` e `map`.

| Ficheiro | Demonstra |
|---|---|
| `listas.kt` | Criar e escrever listas (`listOf`, `emptyList`, `split`); índices, `size`, `indices`, `first`/`last`; `for` por elementos e por índices; acumular; `+`, `-`, `in`/`!in`; partes com `drop`, `dropLast`, `take` e `takeLast`; juntar elementos num `var` |
| `romanos.kt` | Duas listas ligadas pelo mesmo índice (numeração romana, versão simplificada); `return` dentro do `for` |
| `funcoes_sobre_listas.kt` | `forEach`, `filter` e `map` em listas, intervalos e `String`; `forEachWord` e `filterWords` (como poderiam estar definidas); `filter` e `map` em cadeia |
| `exercicios_listas.kt` | Exercícios para completar (marcados com `TODO`); o `main` mostra o esperado e o obtido |

## Como correr
Compilar com `kotlinc` e depois executar com `kotlin`. O nome da classe é o do
ficheiro com a **1.ª letra em maiúscula** e `Kt` no fim (sensível a maiúsculas):

```
kotlinc listas.kt
kotlin ListasKt

kotlinc romanos.kt
kotlin RomanosKt

kotlinc funcoes_sobre_listas.kt
kotlin Funcoes_sobre_listasKt

kotlinc exercicios_listas.kt
kotlin Exercicios_listasKt
```

`romanos.kt` pede um número romano na consola: escrever e carregar em Enter.

Nos exercícios, ir completando uma função de cada vez e voltar a correr: cada linha passa de `ERRADO` a `certo`.
