// Programação (PG) — Aula 11: CanvasLib, desenhar — exemplo integrador (uma cidade à noite)
// Demonstra: o que se juntou nesta aula com o que já se sabia: uma data class para cada prédio, uma função
//            extensão de Canvas que desenha um prédio (com as janelas em dois ciclos for, um dentro do outro),
//            a lista de prédios percorrida com forEach e filter para escolher os que têm antena.
// Correr:  num projeto com a CanvasLib (ver README.md)

import pt.isel.canvas.*

val WIDTH = 500
val HEIGHT = 300
val GROUND = 270             // y da rua: os prédios assentam aqui
val WINDOW = 10              // lado de cada janela
val GAP = 10                 // espaço entre janelas e entre as janelas e as paredes
val TALL = 150               // os prédios mais altos do que isto têm antena
val ANTENNA = 30             // altura da antena
val SKY = 0x1A1033
val MOON = 0xFFF6C8
val LIGHT = 0xF9D56E         // cor das janelas acesas
val ROAD = 0x333333

// Um prédio: o x da parede da esquerda, a largura, a altura e a cor.
data class Building(val x: Int, val width: Int, val height: Int, val color: Int)

// O prédio assente na rua, com as janelas em colunas e filas.
fun Canvas.drawBuilding(b: Building) {
	val top = GROUND - b.height                            // o y do canto superior esquerdo
	drawRect(b.x, top, b.width, b.height, b.color)
	val columns = (b.width - GAP) / (WINDOW + GAP)         // quantas janelas cabem numa fila
	val rows = (b.height - GAP) / (WINDOW + GAP)           // quantas cabem numa coluna
	for (c in 0..<columns) {
		for (r in 0..<rows) {
			drawRect(b.x + GAP + c * (WINDOW + GAP), top + GAP + r * (WINDOW + GAP), WINDOW, WINDOW, LIGHT)
		}
	}
}

// A antena: um segmento vertical por cima do meio do prédio, com uma luz vermelha no topo.
fun Canvas.drawAntenna(b: Building) {
	val middle = b.x + b.width / 2
	val top = GROUND - b.height
	drawLine(middle, top, middle, top - ANTENNA, WHITE, 2)
	drawCircle(middle, top - ANTENNA, 4, RED)
}

fun main(){
	onStart {
		val arena = Canvas(WIDTH, HEIGHT, SKY)
		// a lua em quarto: um círculo claro tapado em parte por outro da cor do céu (o segundo fica por cima)
		arena.drawCircle(60, 50, 25, MOON)
		arena.drawCircle(72, 42, 25, SKY)
		val buildings = listOf(
			Building(20, 70, 110, 0x4A4E69),
			Building(100, 90, 190, 0x3D5A80),
			Building(200, 50, 130, 0x6D597A),
			Building(260, 110, 210, 0x355070),
			Building(380, 90, 170, 0x5C5470)
		)
		buildings.forEach { arena.drawBuilding(it) }
		buildings.filter { it.height > TALL }.forEach { arena.drawAntenna(it) }
		// a rua, com as marcas ao meio de 40 em 40 pixels
		arena.drawRect(0, GROUND, WIDTH, HEIGHT - GROUND, ROAD)
		for (x in 0..<WIDTH step 40) {
			arena.drawLine(x, GROUND + 15, x + 20, GROUND + 15, WHITE, 2)
		}
	}
	onFinish { }
}
