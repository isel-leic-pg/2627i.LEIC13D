// Programação (PG) — Aula 11: CanvasLib, desenhar — formas
// Demonstra: drawRect, drawLine e drawCircle, cheios e só com o contorno (thickness); as posições calculadas
//            a partir de valores com nome (sem "números mágicos"); uma função extensão de Canvas
//            para desenhar duas janelas iguais sem repetir código.
// Correr:  num projeto com a CanvasLib (ver README.md)

import pt.isel.canvas.*

val WIDTH = 400                           // largura da área de desenho
val HEIGHT = 300                          // altura da área de desenho
val GROUND = 250                          // y do chão: daqui para baixo é relva
val HOUSE_WIDTH = 160
val HOUSE_HEIGHT = 100
val HOUSE_X = (WIDTH - HOUSE_WIDTH) / 2   // canto superior esquerdo das paredes: a casa fica ao centro...
val HOUSE_Y = GROUND - HOUSE_HEIGHT       // ... e assente no chão
val ROOF_HEIGHT = 60
val WINDOW_SIDE = 30
val DOOR_WIDTH = 36
val DOOR_HEIGHT = 60

// Uma cor é um Int: as que não são constantes da biblioteca escrevem-se em 0xRRGGBB.
val WALL = 0xF4E1C1
val GLASS = 0xBDEFFF
val WOOD = 0x8B4513
val ORANGE = 0xF88909

// Uma janela com o canto superior esquerdo em (x, y): o vidro, o caixilho e a cruz ao meio.
fun Canvas.drawWindow(x: Int, y: Int) {
	drawRect(x, y, WINDOW_SIDE, WINDOW_SIDE, GLASS)                 // sem thickness: cheio
	drawRect(x, y, WINDOW_SIDE, WINDOW_SIDE, BLACK, 2)              // com thickness: só o contorno
	val half = WINDOW_SIDE / 2
	drawLine(x + half, y, x + half, y + WINDOW_SIDE, BLACK, 2)      // segmento vertical
	drawLine(x, y + half, x + WINDOW_SIDE, y + half, BLACK, 2)      // segmento horizontal
}

fun main(){
	onStart {
		val arena = Canvas(WIDTH, HEIGHT, CYAN)                      // o céu é a cor de fundo
		arena.drawRect(0, GROUND, WIDTH, HEIGHT - GROUND, GREEN)     // a relva
		arena.drawCircle(WIDTH - 60, 60, 30, YELLOW)                 // o sol: um círculo...
		arena.drawCircle(WIDTH - 60, 60, 40, ORANGE, 3)              // ... e uma circunferência à volta
		// as paredes: primeiro cheias, depois o contorno por cima (o que se desenha depois fica por cima)
		arena.drawRect(HOUSE_X, HOUSE_Y, HOUSE_WIDTH, HOUSE_HEIGHT, WALL)
		arena.drawRect(HOUSE_X, HOUSE_Y, HOUSE_WIDTH, HOUSE_HEIGHT, BLACK, 2)
		// o telhado: três segmentos de reta, com o vértice por cima do meio da casa
		val left = HOUSE_X - 10
		val right = HOUSE_X + HOUSE_WIDTH + 10
		val topX = HOUSE_X + HOUSE_WIDTH / 2
		val topY = HOUSE_Y - ROOF_HEIGHT
		arena.drawLine(left, HOUSE_Y, topX, topY, RED, 5)
		arena.drawLine(topX, topY, right, HOUSE_Y, RED, 5)
		arena.drawLine(left, HOUSE_Y, right, HOUSE_Y, RED, 5)
		// a porta, ao meio da casa e assente no chão, com o puxador
		val doorX = HOUSE_X + (HOUSE_WIDTH - DOOR_WIDTH) / 2
		val doorY = GROUND - DOOR_HEIGHT
		arena.drawRect(doorX, doorY, DOOR_WIDTH, DOOR_HEIGHT, WOOD)
		arena.drawCircle(doorX + DOOR_WIDTH - 8, doorY + DOOR_HEIGHT / 2, 3, YELLOW)
		// duas janelas iguais: a mesma função, chamada com cantos diferentes
		arena.drawWindow(HOUSE_X + 20, HOUSE_Y + 20)
		arena.drawWindow(HOUSE_X + HOUSE_WIDTH - 20 - WINDOW_SIDE, HOUSE_Y + 20)
	}
	onFinish { }                                                     // sem isto, fechar a janela não termina o programa
}
