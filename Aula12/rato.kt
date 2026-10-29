// Programação (PG) — Aula 12: CanvasLib, interação — rato
// Demonstra: onMouseDown (um carimbo em cada clique e o MouseEvent escrito na consola) e onMouseMove
//            (arrastar com o botão premido desenha; mexer o rato sem o botão não desenha).
//            Não há estado: cada evento só desenha.
// Correr:  num projeto com a CanvasLib (ver README.md)

import pt.isel.canvas.*

val WIDTH = 400
val HEIGHT = 300
val STAMP = 15          // raio do carimbo do clique
val BRUSH = 3           // raio do pincel

fun main(){
	onStart {
		val arena = Canvas(WIDTH, HEIGHT, WHITE)
		// A cada clique: o MouseEvent na consola e um carimbo verde com centro no clique.
		arena.onMouseDown { me ->
			println(me)
			arena.drawCircle(me.x, me.y, STAMP, GREEN)
		}
		// A cada movimento do rato sobre a área: só desenha se o botão estiver premido (a arrastar).
		arena.onMouseMove { me ->
			if (me.down) arena.drawCircle(me.x, me.y, BRUSH, BLUE)
		}
	}
	onFinish { }
}
