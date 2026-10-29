// Programação (PG) — Aula 11: CanvasLib, desenhar — cores
// Demonstra: as 8 constantes de cor da biblioteca, lado a lado; uma cor é um Int (0xRRGGBB),
//            por isso também se pode calcular: quatro degradês desenhados com um ciclo for.
// Correr:  num projeto com a CanvasLib (ver README.md)

import pt.isel.canvas.*

val COLORS = listOf(BLACK, WHITE, RED, GREEN, BLUE, YELLOW, CYAN, MAGENTA)
const val STEPS = 16                   // retângulos em cada degradê
const val STRIP = 32                   // largura de cada retângulo do degradê
const val ROW = 60                     // altura de cada fila
const val GAP = 10                     // espaço entre filas
const val WIDTH = STEPS * STRIP        // 512
const val HEIGHT = 5 * ROW + 4 * GAP   // 5 filas: 340

// O y da fila n (a primeira é a fila 0).
fun rowY(n: Int) = n * (ROW + GAP)

fun main(){
	onStart {
		val arena = Canvas(WIDTH, HEIGHT, 0x808080)    // fundo cinzento: vê-se entre as filas
		// fila 0: as constantes da biblioteca
		val side = WIDTH / COLORS.size                 // 64
		for (i in COLORS.indices) {
			arena.drawRect(i * side, rowY(0), side, ROW, COLORS[i])
		}
		// filas 1 a 4: degradês. level vai de 0x00 a 0xFF em 16 passos de 0x11.
		// Multiplicar por 0x100 acrescenta dois zeros em hexadecimal: passa o valor para o byte à esquerda.
		for (i in 0..<STEPS) {
			val level = i * 0x11
			val x = i * STRIP
			arena.drawRect(x, rowY(1), STRIP, ROW, level * 0x10000)    // 0xRR0000: só vermelho
			arena.drawRect(x, rowY(2), STRIP, ROW, level * 0x100)      // 0x00GG00: só verde
			arena.drawRect(x, rowY(3), STRIP, ROW, level)              // 0x0000BB: só azul
			arena.drawRect(x, rowY(4), STRIP, ROW, level * 0x10101)    // 0xRRGGBB com os três iguais: cinzentos
		}
	}
	onFinish { }
}
