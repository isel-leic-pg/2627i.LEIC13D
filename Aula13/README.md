# Aula 13 — Exercícios: CanvasLib, interação

Exercícios sobre a matéria da Aula 12: reagir ao rato, ao teclado e ao tempo, com o estado do programa num único `var`.
As funções a completar não desenham: recebem um estado e devolvem outro, por isso testam-se na consola, sem janela.

| Ficheiro | Contém |
|---|---|
| `exercicios_estado.kt` | Exercícios para completar (marcados com `TODO`): as funções que dão o estado seguinte de um ponto com rasto. O `main` mostra o esperado e o obtido e depois abre a janela |
| `exercicios_seguir_refletir.kt` | Mais exercícios para completar (marcados com `TODO`): uma imagem que segue o rato sem sair da área e caixas que refletem nas paredes. O `main` mostra o esperado e o obtido e depois abre a janela |
| `face.png` | A imagem usada em `exercicios_seguir_refletir.kt` (64 × 64, a mesma da Aula 11) |

## Como correr
No IntelliJ, num projeto com a CanvasLib (como na Aula 11): copiar o conteúdo de um ficheiro para o ficheiro
que tem o `main` e correr. **Um ficheiro de cada vez:** os dois têm um `main` e declaram valores com os
mesmos nomes (`WIDTH`, `HEIGHT`, …), por isso não podem estar juntos na pasta `src/` do mesmo projeto.
Para os exercícios `exercicios_seguir_refletir`, o `face.png` tem de estar na pasta `resources/` do projeto.

Na linha de comandos é preciso o ficheiro da biblioteca, `CanvasLib-jvm-1.0.2.jar`, na mesma pasta dos `.kt`
(no IntelliJ não, porque o `module.yaml` já o vai buscar). Descarrega-se do Maven Central:
<https://repo1.maven.org/maven2/io/github/palex65/CanvasLib-jvm/1.0.2/CanvasLib-jvm-1.0.2.jar>

Depois, compilar cada ficheiro para uma pasta diferente e correr a partir desta pasta, onde também está o `face.png`.
O nome da classe é o do ficheiro com a **1.ª letra em maiúscula** e `Kt` no fim:

```
kotlinc exercicios_estado.kt -cp CanvasLib-jvm-1.0.2.jar -d exercicios
kotlin -cp "exercicios;CanvasLib-jvm-1.0.2.jar" Exercicios_estadoKt

kotlinc exercicios_seguir_refletir.kt -cp CanvasLib-jvm-1.0.2.jar -d seguir
kotlin -cp "seguir;CanvasLib-jvm-1.0.2.jar" Exercicios_seguir_refletirKt
```

(No macOS e no Linux, separar com `:` em vez de `;`.)

Para as teclas chegarem ao programa, a janela tem de estar selecionada: clicar nela antes de premir as teclas.

## Exercícios
### O ponto com rasto (`exercicios_estado.kt`)
O estado é um `World` com um ponto (`Dot`: posição e deslocamento) e o rasto (as últimas posições).
Ir completando uma função de cada vez e voltar a correr: cada linha passa de `ERRADO` a `certo`.
Quando estiverem todas certas, o ponto anda sozinho e ressalta nas paredes; as teclas `w`, `a`, `s`, `d` mudam
a direção, o espaço para-o e um clique aponta-o para o sítio do clique.

### Seguir o rato e refletir nas paredes (`exercicios_seguir_refletir.kt`)
O estado é uma `Scene` com o canto superior esquerdo da cara (`Point`) e as caixas (`Box`: canto, lado, cor e
deslocamento). Os exercícios 1 a 4 põem a cara a seguir o rato sem sair da área; os exercícios 5 a 7 põem as caixas
a andar na horizontal e a refletir nas paredes da esquerda e da direita, cada uma à sua velocidade.
Como nos outros exercícios, cada linha passa de `ERRADO` a `certo`. Quando estiverem todas certas, a cara segue
o rato e as caixas andam.

## Desafios
1. Nos exercícios do ponto com rasto (depois de resolvidos), pôr o espaço a alternar entre parar e continuar na mesma direção.
   Que informação tem de passar a fazer parte do estado?
2. Nos exercícios de seguir o rato e refletir (depois de resolvidos), pôr um clique a trocar o sentido de todas as caixas.
3. No `bola.kt` da Aula 12, se clicarmos junto ao topo, a bola fica meio fora da área. Usar o `limitTo` dos exercícios
   de seguir o rato para que isso não aconteça.
