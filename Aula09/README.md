# Aula 9 — Funções extensão e listas

Exemplos e exercícios para acompanhar a Aula 9: funções extensão de tipos simples (`Int`, `Char`, `String`),
o recetor e o `this`, e a nossa `filter` e a nossa `map` escritas como extensões de `List<Int>`.

| Ficheiro | Demonstra |
|---|---|
| `extensoes.kt` | Função normal vs função extensão; extensões de `Int`, `Char` e `String`; `this` explícito e omitido; extensões da biblioteca (`isUpperCase`, `isDigit`) |
| `filter_map.kt` | `filter` e `map` como extensões de `List<Int>`; qual é chamada quando o nome é igual ao da biblioteca |
| `exercicios_extensoes.kt` | Exercícios para completar (marcados com `TODO`): 6 exercícios e 4 extra (fatorial, potência, divisores, contar palavras); o `main` mostra o esperado e o obtido |

## Como correr
Compilar com `kotlinc` e depois executar com `kotlin`. O nome da classe é o do
ficheiro com a **1.ª letra em maiúscula** e `Kt` no fim (sensível a maiúsculas):

```
kotlinc extensoes.kt
kotlin ExtensoesKt

kotlinc filter_map.kt
kotlin Filter_mapKt

kotlinc exercicios_extensoes.kt
kotlin Exercicios_extensoesKt
```

Nos exercícios, ir completando uma função de cada vez e voltar a correr: cada linha passa de `ERRADO` a `certo`.
