# Aula 12 — CanvasLib: interação

Exemplos para acompanhar a Aula 12: reagir ao rato (`onMouseDown`, `onMouseMove`, `mouse`),
ao teclado (`onKeyPressed`) e ao tempo (`onTime`, `onTimeProgress`), com o estado do programa num único `var`.

| Ficheiro | Demonstra |
|---|---|
| `rato.kt` | `onMouseDown` (um carimbo em cada clique e o `MouseEvent` na consola) e `onMouseMove` (arrastar com o botão premido desenha; mexer sem o botão não desenha). Sem estado |
| `teclado.kt` | `onKeyPressed` e o que chega em cada `KeyEvent` (na consola); as setas e o Esc pelo `code`, as letras pelo `char`; um quadrado guardado num único `var` (as setas mexem-no e, se sair por um lado, entra pelo outro) |
| `tempo.kt` | `onTimeProgress` (uma barra que cresce com o tempo decorrido `tm`), `onTime` (passados 5 segundos), `TimerCtrl.stop` e a propriedade `mouse` lida dentro do temporizador |
| `bola.kt` | O exemplo final dos slides: a bola anda sozinha e reflete nas paredes, vai para onde se clica e muda de raio com `r` e `R`. Um único `var`; só o temporizador desenha |

## Como correr
No IntelliJ, num projeto com a CanvasLib (como na Aula 11): copiar o conteúdo de um ficheiro para o ficheiro
que tem o `main` e correr. **Um ficheiro de cada vez:** todos têm um `main` e vários declaram valores com os
mesmos nomes (`WIDTH`, `HEIGHT`, …), por isso não podem estar juntos na pasta `src/` do mesmo projeto.

Na linha de comandos é preciso o ficheiro da biblioteca, `CanvasLib-jvm-1.0.2.jar`, na mesma pasta dos `.kt`
(no IntelliJ não, porque o `module.yaml` já o vai buscar). Descarrega-se do Maven Central:
<https://repo1.maven.org/maven2/io/github/palex65/CanvasLib-jvm/1.0.2/CanvasLib-jvm-1.0.2.jar>

Depois, compilar cada ficheiro para uma pasta diferente e correr a partir desta pasta.
O nome da classe é o do ficheiro com a **1.ª letra em maiúscula** e `Kt` no fim:

```
kotlinc rato.kt -cp CanvasLib-jvm-1.0.2.jar -d rato
kotlin -cp "rato;CanvasLib-jvm-1.0.2.jar" RatoKt

kotlinc teclado.kt -cp CanvasLib-jvm-1.0.2.jar -d teclado
kotlin -cp "teclado;CanvasLib-jvm-1.0.2.jar" TecladoKt

kotlinc tempo.kt -cp CanvasLib-jvm-1.0.2.jar -d tempo
kotlin -cp "tempo;CanvasLib-jvm-1.0.2.jar" TempoKt

kotlinc bola.kt -cp CanvasLib-jvm-1.0.2.jar -d bola
kotlin -cp "bola;CanvasLib-jvm-1.0.2.jar" BolaKt
```

(No macOS e no Linux, separar com `:` em vez de `;`.)

Para as teclas chegarem ao programa, a janela tem de estar selecionada: clicar nela antes de premir as teclas.

## Desafios
1. No `rato.kt`, ao arrastar depressa ficam falhas entre os pontos. Desenhar antes uma linha (`drawLine`) desde
   a posição anterior do rato até à atual. O que passa a ser preciso guardar?
2. No `bola.kt`, se clicarmos junto ao topo, a bola fica meio fora da área. Alterar o programa para que isso não aconteça.
