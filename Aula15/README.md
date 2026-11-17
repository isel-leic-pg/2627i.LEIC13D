# Aula 15 — Enumerados

Exemplos e exercícios para acompanhar a Aula 15: declarar um tipo com um conjunto fixo de valores (`enum class`),
usá-lo num `when` sem `else`, as propriedades `name` e `ordinal`, a lista `entries`, converter texto num enumerado,
enumerados com propriedades e com funções extensão, e enumerados dentro de uma `data class`.

| Ficheiro | Demonstra |
|---|---|
| `direcoes.kt` | `enum class Dir`; `when` com um ramo por valor, sem `else`; `name`, `ordinal` e comparar pela ordem da declaração; `entries` (percorrer, indexar, `filter`, `random`); `valueOf` e a nossa `dirOf`, que devolve `Dir?` |
| `direcoes_propriedades.kt` | `Dir` com propriedades (`dx`, `dy`) e `Point.move`; funções extensão de enumerados (`reverse`, `turnRight`, `Signal.next`); um robô (`data class Robot`) com a posição e a direção |
| `pedra_papel_tesoura.kt` | O exemplo final dos slides: pedra, papel, tesoura contra o computador (lê da consola) |
| `exercicios_enumerados.kt` | Exercícios para completar (marcados com `TODO`) sobre as cartas de um baralho de sueca: os naipes (`Suit`), os valores (`Rank`, com os pontos) e as cartas (`Card`); 8 exercícios e 2 extra; o `main` mostra o esperado e o obtido |

## Como correr
Compilar cada ficheiro **para uma pasta diferente** (`-d`) e correr a partir dessa pasta (`-cp`). Os dois exemplos
das direções declaram dois `Dir` diferentes (um sem e outro com propriedades): se fossem compilados para a mesma
pasta, o segundo substituía o `Dir` do primeiro e o primeiro deixava de correr.
O nome da classe é o do ficheiro com a **1.ª letra em maiúscula** e `Kt` no fim (sensível a maiúsculas):

```
kotlinc direcoes.kt -d direcoes
kotlin -cp direcoes DirecoesKt

kotlinc direcoes_propriedades.kt -d propriedades
kotlin -cp propriedades Direcoes_propriedadesKt

kotlinc pedra_papel_tesoura.kt -d jogo
kotlin -cp jogo Pedra_papel_tesouraKt

kotlinc exercicios_enumerados.kt -d exercicios
kotlin -cp exercicios Exercicios_enumeradosKt
```

No IntelliJ, um ficheiro de cada vez: todos têm um `main`, e os dois das direções declaram um `Dir` cada um.

Nos exemplos, as linhas comentadas que acabam em «não compila» ou «termina com …» mostram os erros: tirar o `//`,
correr, ver a mensagem e voltar a pôr o `//`.

## Exercícios
Na sueca, os valores, do mais fraco para o mais forte, são 2, 3, 4, 5, 6, Dama, Valete, Rei, 7 e Ás, e é por esta ordem
que estão declarados em `Rank`. Os exercícios 1 a 5 são sobre um naipe, uma carta ou um valor; os 6 a 8 sobre listas
de cartas; o 9 e o 10 são extra.
Ir completando uma função de cada vez e voltar a correr: cada linha passa de `ERRADO` a `certo`.
Alguns exercícios usam funções feitas antes (o último teste do 8 usa o 6; o 9 usa o 5; o 10 usa o 3).
