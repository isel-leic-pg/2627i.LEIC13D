// Programação (PG) — Aula 12: CanvasLib, interação — exemplo final (o dos slides)
// Demonstra: o estado do programa (a bola) num único var; cada evento calcula o estado novo com uma função:
//            o temporizador com move (reflete nas paredes), o clique com copy e as teclas r e R com resize.
//            Só o temporizador desenha.
// Correr:  num projeto com a CanvasLib (ver README.md); clicar na janela antes de premir as teclas

import pt.isel.canvas.*

val WIDTH = 600
val HEIGHT = 300
val SPEED = 4                 // píxeis por imagem
val PERIOD = 20               // ms entre imagens: 50 por segundo
val STEP = 5                  // variação do raio a cada tecla
val RADIUS_RANGE = 10..100    // raios possíveis

data class Ball(val x: Int, val y: Int, val dx: Int, val radius: Int)

// a bola na imagem seguinte: troca de sentido junto às paredes
fun Ball.move(): Ball {
	val newDx = when {
		x + dx > WIDTH - radius -> -SPEED
		x + dx < radius -> SPEED
		else -> dx
	}
	return copy(x = x + newDx, dx = newDx)
}

// a bola depois de uma tecla: r diminui o raio, R aumenta
fun Ball.resize(key: Char): Ball {
	val r = when (key) {
		'r' -> radius - STEP
		'R' -> radius + STEP
		else -> radius
	}
	return if (r in RADIUS_RANGE) copy(radius = r) else this
}

fun Canvas.drawBall(b: Ball) {
	erase()
	drawCircle(b.x, b.y, b.radius, RED)
}

fun main(){
	onStart {
		val arena = Canvas(WIDTH, HEIGHT, BLACK)
		var ball = Ball(WIDTH / 2, HEIGHT / 2, SPEED, 50)   // o único var
		arena.onMouseDown { me -> ball = ball.copy(x = me.x, y = me.y) }
		arena.onKeyPressed { k -> ball = ball.resize(k.char) }
		arena.onTimeProgress(PERIOD) {
			ball = ball.move()
			arena.drawBall(ball)
		}
	}
	onFinish { }
}
