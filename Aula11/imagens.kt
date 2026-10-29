// Programação (PG) — Aula 11: CanvasLib, desenhar — imagens
// Demonstra: drawImage com o tamanho do ficheiro, ampliada, reduzida e esticada, e repetida num ciclo for.
//            (x, y) é o canto superior esquerdo da imagem, como no drawRect.
//            O ficheiro face.png (64 × 64) tem de estar na pasta resources/ do projeto
//            (na linha de comandos, na pasta onde se corre o programa).
// Correr:  num projeto com a CanvasLib (ver README.md)

import pt.isel.canvas.*

const val WIDTH = 480
const val HEIGHT = 300
const val FACE = "face"      // o nome do ficheiro: sem extensão, assume-se .png
const val FACE_SIZE = 64     // o ficheiro tem 64 × 64 pixels
const val MARGIN = 10

fun main(){
	onStart {
		val arena = Canvas(WIDTH, HEIGHT, WHITE)
		// em cima: a mesma imagem com tamanhos diferentes, todas com o canto superior em y = MARGIN
		arena.drawImage(FACE, MARGIN, MARGIN)                               // o tamanho do ficheiro: 64 × 64
		arena.drawImage(FACE, 90, MARGIN, 2 * FACE_SIZE, 2 * FACE_SIZE)     // ampliada: 128 × 128
		arena.drawImage(FACE, 235, MARGIN, FACE_SIZE / 2, FACE_SIZE / 2)    // reduzida: 32 × 32
		arena.drawImage(FACE, 285, MARGIN, 180, FACE_SIZE)                  // esticada: 180 × 64
		// em baixo: cinco caras cada vez maiores, todas assentes na linha y = HEIGHT - MARGIN
		for (i in 1..5) {
			val size = i * 16                        // 16, 32, 48, 64, 80
			val x = MARGIN + (i - 1) * 95
			arena.drawImage(FACE, x, HEIGHT - MARGIN - size, size, size)
		}
		arena.drawLine(0, HEIGHT - MARGIN, WIDTH, HEIGHT - MARGIN, RED, 1)  // a linha onde assentam
	}
	onFinish { }
}
