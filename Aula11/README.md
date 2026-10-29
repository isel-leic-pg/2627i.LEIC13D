# Aula 11 — CanvasLib: desenhar

Exemplos para acompanhar a Aula 11: a área de desenho (`Canvas`), as coordenadas, as cores e as quatro funções
de desenho dos slides (`drawLine`, `drawRect`, `drawCircle` e `drawImage`). Só desenham: reagir ao rato,
ao teclado e ao tempo fica para a Aula 12.

| Ficheiro | Demonstra |
|---|---|
| `formas.kt` | Uma casa: `drawRect`, `drawLine` e `drawCircle`, cheios e só com o contorno (`thickness`); as posições calculadas a partir de valores com nome; `fun Canvas.drawWindow` para desenhar duas janelas iguais |
| `cores.kt` | As 8 constantes de cor da biblioteca e quatro degradês (vermelho, verde, azul e cinzentos) calculados num `for`: uma cor é um `Int` em `0xRRGGBB` |
| `imagens.kt` | `drawImage` com o tamanho do ficheiro, ampliada, reduzida e esticada, e cinco imagens cada vez maiores desenhadas num `for` |
| `cidade.kt` | Exemplo integrador, uma cidade à noite: `data class Building`, `fun Canvas.drawBuilding` com as janelas em dois `for` encadeados, uma lista de prédios percorrida com `forEach` e `filter` (só os prédios altos têm antena) |
| `face.png` | A imagem usada no `imagens.kt` (64 × 64, a mesma dos slides) |

## Como correr
No IntelliJ, num projeto com a CanvasLib (como nos slides): copiar o conteúdo de um ficheiro para o ficheiro
que tem o `main` e correr. **Um ficheiro de cada vez:** todos têm um `main` e declaram valores com os mesmos nomes
(`WIDTH`, `HEIGHT`, …), por isso não podem estar juntos na pasta `src/` do mesmo projeto.
Para o `imagens.kt`, o `face.png` tem de estar na pasta `resources/` do projeto; se faltar, o programa para com o erro
`Cant open face.png in working directory or in resources`.

Na linha de comandos é preciso o ficheiro da biblioteca, `CanvasLib-jvm-1.0.2.jar`, na mesma pasta dos `.kt`
(no IntelliJ não, porque o `module.yaml` já o vai buscar). Descarrega-se do Maven Central:
<https://repo1.maven.org/maven2/io/github/palex65/CanvasLib-jvm/1.0.2/CanvasLib-jvm-1.0.2.jar>

Depois, compilar cada ficheiro para uma pasta diferente e correr a partir desta pasta, onde também está o `face.png`.
O nome da classe é o do ficheiro com a **1.ª letra em maiúscula** e `Kt` no fim:

```
kotlinc formas.kt -cp CanvasLib-jvm-1.0.2.jar -d formas
kotlin -cp "formas;CanvasLib-jvm-1.0.2.jar" FormasKt

kotlinc cores.kt -cp CanvasLib-jvm-1.0.2.jar -d cores
kotlin -cp "cores;CanvasLib-jvm-1.0.2.jar" CoresKt

kotlinc imagens.kt -cp CanvasLib-jvm-1.0.2.jar -d imagens
kotlin -cp "imagens;CanvasLib-jvm-1.0.2.jar" ImagensKt

kotlinc cidade.kt -cp CanvasLib-jvm-1.0.2.jar -d cidade
kotlin -cp "cidade;CanvasLib-jvm-1.0.2.jar" CidadeKt
```

(No macOS e no Linux, separar com `:` em vez de `;`.)

## Desafios
1. No `formas.kt`, mudar só o `HOUSE_X` para pôr a casa encostada à esquerda: as paredes, o telhado, a porta e as
   janelas acompanham, porque as posições são calculadas a partir dele. Depois, desenhar uma árvore no espaço
   que ficou livre (um tronco e uma copa).
2. No `cores.kt`, acrescentar uma fila com um degradê de preto para amarelo. Por que valor se multiplica `level`?
3. No `cidade.kt`, mudar a largura e a altura de um prédio: as janelas ajustam-se sozinhas, porque o número de
   colunas e de filas é calculado. Depois, acrescentar estrelas: uma lista de pontos (`data class`) desenhados com `forEach`.
