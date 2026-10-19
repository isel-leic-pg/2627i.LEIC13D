# Aula 7 — Funções como valores e lambdas

Exemplos para acompanhar a Aula 7: tipos de função, o operador `::`, funções como
parâmetro, expressões lambda, a sintaxe curta (lambda fora dos parênteses e `it`) e `repeat`.

| Ficheiro | Demonstra |
|---|---|
| `funcoes_como_valores.kt` | Tipos de função; `::`; variáveis que guardam funções; `printInFx` e `printTable` (função como parâmetro) |
| `lambdas.kt` | Anatomia da lambda; as quatro formas da mesma chamada; `it`; lambda com dois parâmetros; lambda com várias instruções (`.B.D.F`) |
| `repeat.kt` | `repeat` com `it` (número da volta); `repeat` dentro de uma função; comparação com `for` |
| `calculadora_funcoes.kt` | Integrador: o `when` escolhe uma função (`::add`, lambdas), que é passada a `showOp`; `do-while` para repetir |

## Como correr
Compilar com `kotlinc` e depois executar com `kotlin`. O nome da classe é o do
ficheiro com a **1.ª letra em maiúscula** e `Kt` no fim (sensível a maiúsculas):

```
kotlinc funcoes_como_valores.kt
kotlin Funcoes_como_valoresKt

kotlinc lambdas.kt
kotlin LambdasKt

kotlinc repeat.kt
kotlin RepeatKt

kotlinc calculadora_funcoes.kt
kotlin Calculadora_funcoesKt
```

`repeat.kt` e `calculadora_funcoes.kt` pedem dados na consola: escrever cada resposta e carregar em Enter.
