# Aula 10 — Tipos agregados (data class)

Exemplos e exercícios para acompanhar a Aula 10: definir tipos com `data class`, criar objetos, aceder às
propriedades, comparar com `==`, funções que recebem e devolvem objetos, composição, funções extensão de
tipos agregados e `copy`.

| Ficheiro | Demonstra |
|---|---|
| `pontos.kt` | `data class Point`; criar objetos com argumentos posicionais, nomeados e por omissão; `pt.x`; `println` e templates; `==`; `addPoints` e `multPoint`; uma função que devolve dois valores juntos num `Point` |
| `circulos.kt` | Composição (`Circle` com um `Point` como centro); funções extensão de `Point` e de `Int`, com o `this` explícito e omitido; `moveCircle` (função normal) e `move` (extensão com `copy`); listas de objetos com `forEach`, `filter` e `map` |
| `exercicios_data_class.kt` | Exercícios para completar (marcados com `TODO`) sobre uma agenda: horas (`Time`) e marcações (`Appointment`, com uma `Time` lá dentro); 8 exercícios e 2 extra; o `main` mostra o esperado e o obtido |

## Como correr
Compilar com `kotlinc` e depois executar com `kotlin`. O nome da classe é o do
ficheiro com a **1.ª letra em maiúscula** e `Kt` no fim (sensível a maiúsculas):

```
kotlinc pontos.kt
kotlin PontosKt

kotlinc circulos.kt
kotlin CirculosKt

kotlinc exercicios_data_class.kt
kotlin Exercicios_data_classKt
```

Nos exercícios, ir completando uma função de cada vez e voltar a correr: cada linha passa de `ERRADO` a `certo`.
