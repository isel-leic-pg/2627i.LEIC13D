// Programação (PG) — Aula 12: CanvasLib, interação — teclado
// Demonstra: onKeyPressed e o que chega em cada KeyEvent (escrito na consola); as setas e o Esc pelo code,
//            as letras pelo char; o estado (o quadrado) num único var; um só onKeyPressed para todas as teclas.
// Correr:  num projeto com a CanvasLib (ver README.md); clicar na janela antes de premir as teclas

import pt.isel.canvas.*

val WIDTH = 400
val HEIGHT = 300
val SIDE = 40           // lado do quadrado
val STEP = 20           // píxeis por tecla

data class Square(val x: Int, val y: Int, val color: Int)

// O quadrado ao centro da área, com a cor color.
fun center(color: Int) = Square((WIDTH - SIDE) / 2, (HEIGHT - SIDE) / 2, color)

fun Canvas.drawSquare(sq: Square) {
	erase()
	drawRect(sq.x, sq.y, SIDE, SIDE, sq.color)
}

// O quadrado depois da tecla com o código code: as setas deslocam-no STEP píxeis
// (se sair por um lado, entra pelo outro) e o Esc põe-no ao centro; as outras teclas não o mexem.
fun Square.move(code: Int): Square = when (code) {
	LEFT_CODE -> copy(x = (x - STEP + WIDTH) % WIDTH)
	RIGHT_CODE -> copy(x = (x + STEP) % WIDTH)
	UP_CODE -> copy(y = (y - STEP + HEIGHT) % HEIGHT)
	DOWN_CODE -> copy(y = (y + STEP) % HEIGHT)
	ESCAPE_CODE -> center(color)
	else -> this
}

// O quadrado depois da tecla com o símbolo ch: r, g e b mudam a cor; as outras teclas não mudam nada.
fun Square.paint(ch: Char): Square = when (ch) {
	'r' -> copy(color = RED)
	'g' -> copy(color = GREEN)
	'b' -> copy(color = BLUE)
	else -> this
}

// O KeyEvent em texto. As teclas sem símbolo (setas, Shift, ...) têm char igual a UNDEFINED_CHAR;
// os outros carateres de controlo (Enter, Backspace, ...) escrevem-se pelo código, entre parênteses,
// para não baralhar a consola.
fun describe(k: KeyEvent): String {
	val ch = when {
		k.char == UNDEFINED_CHAR -> "UNDEFINED_CHAR"
		k.char == ESCAPE -> "ESCAPE"
		k.char < ' ' -> "(${k.char.code})"
		else -> "'${k.char}'"
	}
	return "char=$ch code=${k.code} text=${k.text}"
}

fun main(){
	onStart {
		val arena = Canvas(WIDTH, HEIGHT, BLACK)
		var square = center(WHITE)          // o único var
		arena.drawSquare(square)
		// Um só onKeyPressed (um segundo substituía este): trata as setas, o Esc e as letras.
		arena.onKeyPressed { k ->
			println(describe(k))
			square = square.move(k.code).paint(k.char)
			arena.drawSquare(square)
		}
	}
	onFinish { }
}
