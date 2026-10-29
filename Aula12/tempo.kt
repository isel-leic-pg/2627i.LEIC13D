// Programação (PG) — Aula 12: CanvasLib, interação — tempo
// Demonstra: onTimeProgress (uma barra que cresce com o tempo decorrido, tm); onTime (uma só vez, passados
//            5 segundos); TimerCtrl.stop (parar o temporizador); a propriedade mouse, lida dentro do temporizador.
// Correr:  num projeto com a CanvasLib (ver README.md)

import pt.isel.canvas.*

const val WIDTH = 400
const val HEIGHT = 200
const val DURATION = 5000   // ms até a barra ficar cheia
const val PERIOD = 50       // ms entre imagens: 1000 / 50 = 20 imagens por segundo
const val MARGIN = 20       // distância da barra às paredes da esquerda e da direita
const val BAR_Y = 80
const val BAR_WIDTH = WIDTH - 2 * MARGIN
const val BAR_HEIGHT = 40
const val POINTER = 5       // raio do ponto que mostra o rato

// A barra preenchida até length píxeis, com o contorno da barra cheia.
fun Canvas.drawBar(length: Int, color: Int) {
	erase()
	drawRect(MARGIN, BAR_Y, BAR_WIDTH, BAR_HEIGHT, WHITE, 2)
	drawRect(MARGIN, BAR_Y, length, BAR_HEIGHT, color)
}

fun main(){
	onStart {
		val arena = Canvas(WIDTH, HEIGHT, BLACK)
		// A cada PERIOD ms. tm é o tempo decorrido, em ms, desde que onTimeProgress foi chamada (um Long).
		val timer = arena.onTimeProgress(PERIOD) { tm ->
			val length = if (tm >= DURATION) BAR_WIDTH else (tm * BAR_WIDTH / DURATION).toInt()
			arena.drawBar(length, YELLOW)
			val m = arena.mouse                 // a última posição conhecida do rato
			arena.drawCircle(m.x, m.y, POINTER, RED)
		}
		// Uma só vez, passados DURATION ms: para o temporizador e pinta a barra cheia de verde.
		arena.onTime(DURATION) {
			timer.stop()
			arena.drawBar(BAR_WIDTH, GREEN)
		}
	}
	onFinish { }
}
