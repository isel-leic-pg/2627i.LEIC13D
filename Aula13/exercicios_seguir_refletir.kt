// Programação (PG) — Aula 13: CanvasLib, interação  (exercícios: seguir o rato e refletir nas paredes)
// Completar as funções marcadas com TODO. Cada uma devolve, para já, um valor fixo para o ficheiro compilar.
// O main começa por mostrar na consola, para cada exercício, o valor esperado e o valor obtido,
// e depois abre a janela: a cara só segue o rato e as caixas só andam quando as funções estiverem feitas.
// Alguns testes podem dar certo por acaso antes de a função estar feita: o objetivo é ficarem todos certos.
// Nenhuma destas funções desenha nem altera nada: recebem valores e devolvem outros.
// Regra: não usar funções da biblioteca que já resolvam o exercício (coerceIn, coerceAtLeast, coerceAtMost, ...).
// Correr:  num projeto com a CanvasLib e com o ficheiro face.png na pasta resources/ (ver README.md)

import pt.isel.canvas.*

const val WIDTH = 600
const val HEIGHT = 300
const val FACE = "face"     // o ficheiro face.png, sem a extensão
const val FACE_SIZE = 64    // a imagem tem 64 × 64 pixels
const val PERIOD = 20       // ms entre imagens: 50 por segundo

// Uma posição na área de desenho.
data class Point(val x: Int, val y: Int)

// Uma caixa quadrada que anda na horizontal: o canto superior esquerdo (x, y), o lado, a cor
// e o deslocamento por imagem (dx > 0 para a direita, dx < 0 para a esquerda).
data class Box(val x: Int, val y: Int, val side: Int, val color: Int, val dx: Int)

// O estado do programa: o canto superior esquerdo da cara e as caixas.
data class Scene(val face: Point, val boxes: List<Box>)

// ---------------------------------------------------------------- seguir o rato

// 1. Os valores possíveis do canto de uma figura com o lado size, numa área com o comprimento length,
//    para a figura caber inteira: de 0 até ao último canto possível.
fun cornerRange(length: Int, size: Int): IntRange {
	return 0..0 // TODO
}

// 2. O valor do intervalo r mais perto deste Int: abaixo do início dá o início, acima do fim dá o fim;
//    dentro do intervalo, fica igual.
fun Int.limitTo(r: IntRange): Int {
	return this // TODO
}

// 3. O canto da cara para o rato em (mouseX, mouseY): a cara fica com o centro no rato,
//    mas sem sair da área. Usar cornerRange e limitTo.
fun faceAt(mouseX: Int, mouseY: Int): Point {
	return Point(0, 0) // TODO
}

// 4. A cena depois de o rato se mexer para (mouseX, mouseY): a cara passa para o sítio dado por faceAt
//    e as caixas ficam iguais. Usar copy.
fun Scene.follow(mouseX: Int, mouseY: Int): Scene {
	return this // TODO
}

// ---------------------------------------------------------------- refletir nas paredes

// 5. O deslocamento na imagem seguinte para quem está em pos e se desloca d de cada vez:
//    se pos + d sair do intervalo r, troca de sentido (-d); senão, continua (d).
fun reflect(pos: Int, d: Int, r: IntRange): Int {
	return d // TODO
}

// 6. A caixa na imagem seguinte: reflete nas paredes da esquerda e da direita e avança o novo deslocamento.
//    A caixa tem de caber inteira na área. Usar reflect e cornerRange.
fun Box.move(): Box {
	return this // TODO
}

// 7. A cena na imagem seguinte: todas as caixas avançam (usar move); a cara fica onde está.
fun Scene.tick(): Scene {
	return this // TODO
}

// ---------------------------------------------------------------- os testes (na consola)

// Any: um valor de qualquer tipo (Int, Point, Box, Scene, ...).
fun check(name: String, expected: Any, obtained: Any) {
	val mark = if (expected == obtained) "certo" else "ERRADO"
	println("$name: esperado $expected, obtido $obtained -> $mark")
}

// Os valores esperados contam com WIDTH = 600, HEIGHT = 300 e FACE_SIZE = 64.
fun checks() {
	check("1. cornerRange(600, 64)", 0..536, cornerRange(600, 64))
	check("1. cornerRange(300, 64)", 0..236, cornerRange(300, 64))
	check("1. cornerRange(500, 30)", 0..470, cornerRange(500, 30))
	check("2. 700.limitTo(0..536)", 536, 700.limitTo(0..536))
	check("2. (-20).limitTo(0..536)", 0, (-20).limitTo(0..536))
	check("2. 300.limitTo(0..536)", 300, 300.limitTo(0..536))
	check("3. faceAt(300, 150)", Point(268, 118), faceAt(300, 150))
	check("3. faceAt(590, 295)", Point(536, 236), faceAt(590, 295))
	check("3. faceAt(10, 200)", Point(0, 168), faceAt(10, 200))
	check("3. faceAt(5, 5)", Point(0, 0), faceAt(5, 5))
	val box = Box(100, 50, 40, RED, 4)
	check("4. follow", Scene(Point(268, 118), listOf(box)), Scene(Point(0, 0), listOf(box)).follow(300, 150))
	check("5. reflect(100, 5, 0..560)", 5, reflect(100, 5, 0..560))
	check("5. reflect(558, 5, 0..560)", -5, reflect(558, 5, 0..560))
	check("5. reflect(560, 5, 0..560)", -5, reflect(560, 5, 0..560))
	check("5. reflect(3, -5, 0..560)", 5, reflect(3, -5, 0..560))
	check("6. move no meio", Box(104, 50, 40, RED, 4), Box(100, 50, 40, RED, 4).move())
	check("6. move na parede da direita", Box(554, 50, 40, RED, -4), Box(558, 50, 40, RED, 4).move())
	check("6. move na parede da esquerda", Box(6, 50, 40, RED, 4), Box(2, 50, 40, RED, -4).move())
	val before = Scene(Point(10, 10), listOf(Box(100, 50, 40, RED, 4), Box(558, 150, 40, BLUE, 4)))
	val after = Scene(Point(10, 10), listOf(Box(104, 50, 40, RED, 4), Box(554, 150, 40, BLUE, -4)))
	check("7. tick", after, before.tick())
}

// ---------------------------------------------------------------- a janela (já está feita)

fun Canvas.drawScene(s: Scene) {
	erase()
	s.boxes.forEach { drawRect(it.x, it.y, it.side, it.side, it.color) }
	drawImage(FACE, s.face.x, s.face.y)
}

fun main(){
	checks()
	onStart {
		val arena = Canvas(WIDTH, HEIGHT, BLACK)
		val boxes = listOf(Box(0, 30, 40, RED, 3), Box(250, 120, 60, GREEN, -5), Box(500, 210, 30, YELLOW, 8))
		var scene = Scene(faceAt(WIDTH / 2, HEIGHT / 2), boxes)    // o único var
		arena.onMouseMove { me -> scene = scene.follow(me.x, me.y) }
		arena.onTimeProgress(PERIOD) {
			scene = scene.tick()
			arena.drawScene(scene)
		}
	}
	onFinish { }
}
