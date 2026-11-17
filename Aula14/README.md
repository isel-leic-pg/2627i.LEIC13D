# Aula 14 — Tipos anuláveis

Exemplos e exercícios para acompanhar a Aula 14: valores que podem faltar, o tipo `T?` e o `null`, o smart cast,
os operadores `?.`, `?:` e `!!`, as funções da biblioteca que devolvem `null` e as nossas funções que devolvem `T?`.

| Ficheiro | Demonstra |
|---|---|
| `anulaveis.kt` | `toInt` e `toIntOrNull`; `Int?` e `null`; smart cast no `if`, no `when`, depois de um `return` e à direita de `&&` e de `\|\|`; `?.` (também encadeado), `?:` (também com `return`) e `!!` |
| `funcoes_com_null.kt` | `toIntOrNull`, `toDoubleOrNull`, `firstOrNull`, `lastOrNull` e `getOrNull`; a nossa `positionOf`, que devolve `Int?`; uma `data class` com uma propriedade anulável (`Contact`, com `phone: String?`) |
| `ler_nota.kt` | Ler uma nota de 0 a 20 até ser válida, com `do-while` e `toIntOrNull` (lê da consola) |
| `exercicios_anulaveis.kt` | Exercícios para completar (marcados com `TODO`) sobre um parque de estacionamento: cada lugar (`Spot`) tem um carro ou nenhum (`plate: String?`); 8 exercícios e 2 extra; o `main` mostra o esperado e o obtido |

## Como correr
Compilar com `kotlinc` e depois executar com `kotlin`. O nome da classe é o do
ficheiro com a **1.ª letra em maiúscula** e `Kt` no fim (sensível a maiúsculas):

```
kotlinc anulaveis.kt
kotlin AnulaveisKt

kotlinc funcoes_com_null.kt
kotlin Funcoes_com_nullKt

kotlinc ler_nota.kt
kotlin Ler_notaKt

kotlinc exercicios_anulaveis.kt
kotlin Exercicios_anulaveisKt
```

No IntelliJ, um ficheiro de cada vez: todos têm um `main`.

Nos exemplos, as linhas comentadas que acabam em «não compila» ou «termina com …» mostram os erros: tirar o `//`,
correr, ver a mensagem e voltar a pôr o `//`.

## Exercícios
O parque é uma lista de lugares (`List<Spot>`), pela ordem dos números: o lugar 1 está no índice 0.
Os exercícios 1 a 3 são sobre um lugar e os 4 a 8 sobre o parque; o 9 e o 10 são extra.
Ir completando uma função de cada vez e voltar a correr: cada linha passa de `ERRADO` a `certo`.
Alguns exercícios usam funções feitas antes (o 5 pode usar o 1; o 6 usa o 5; o 10 usa o 6).
