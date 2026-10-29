# Aula 4 — Decisões

Exemplos para acompanhar a Aula 4: `if` e `when`, como instrução e como expressão.

| Ficheiro | Demonstra |
|---|---|
| `if_decisoes.kt` | `if` instrução, `if` expressão, cadeia `else if` |
| `when_decisoes.kt` | `when` com sujeito, sem sujeito e como expressão (com `in`) |
| `calculadora.kt` | Integrador: `readln()` + `when` expressão (I/O da Aula 3) |

## Como correr
Compilar com `kotlinc` e depois executar com `kotlin`. O nome da classe é o do
ficheiro com a **1.ª letra em maiúscula** e `Kt` no fim (sensível a maiúsculas):

```
kotlinc if_decisoes.kt
kotlin If_decisoesKt

kotlinc when_decisoes.kt
kotlin When_decisoesKt

kotlinc calculadora.kt
kotlin CalculadoraKt
```

O `calculadora.kt` pede dados na consola: escrever cada resposta e carregar em Enter.