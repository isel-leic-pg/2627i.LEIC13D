// Programação (PG) — Aula 13: CanvasLib, interação  (exercícios)
// Completar as funções marcadas com TODO. Cada uma devolve, para já, um valor fixo para o ficheiro compilar.
// O main começa por mostrar na consola, para cada exercício, o valor esperado e o valor obtido,
// e depois abre a janela: o ponto só ganha vida quando as funções estiverem feitas.
// Alguns testes podem dar certo por acaso antes de a função estar feita: o objetivo é ficarem todos certos.
// Nenhuma destas funções desenha nem altera nada: recebem um estado e devolvem outro.
// Regra: não usar funções da biblioteca que já resolvam o exercício (takeLast, drop, sign, coerceIn, ...).
// Correr:  num projeto com a CanvasLib (ver README.md); clicar na janela antes de premir as teclas

import pt.isel.canvas.*

const val WIDTH = 600
const val HEIGHT = 300
const val RADIUS = 10       // raio do ponto
const val SPEED = 3         // píxeis por imagem
const val PERIOD = 20       // ms entre imagens: 50 por segundo
const val TRAIL_SIZE = 15   // número de posições do rasto
const val DOT_COLOR = YELLOW
const val TRAIL_COLOR = 0x7F52FF

data class Point(val x: Int, val y: Int)

// O ponto que se mexe: a posição do centro e o deslocamento por imagem (dx para a direita, dy para baixo).
data class Dot(val x: Int, val y: Int, val dx: Int, val dy: Int)

// O estado do programa: o ponto e o rasto (as últimas posições do ponto, da mais antiga para a mais recente).
data class World(val dot: Dot, val trail: List<Point>)

// 1. O ponto na imagem seguinte, sem paredes: x avança dx e y avança dy.
fun Dot.move(): Dot {
	return this // TODO
}

// 2. Como move, mas reflete nas quatro paredes (o ponto tem de caber inteiro na área):
//    se o próximo x passasse a parede da direita, dx passa a ser -SPEED; se passasse a da esquerda, SPEED.
//    O mesmo para y e dy, com as paredes de baixo e de cima. Depois avança, como em move.
fun Dot.bounce(): Dot {
	return this // TODO
}

// 3. O ponto depois da tecla com o símbolo key: w, a, s e d põem-no a andar só para cima, para a esquerda,
//    para baixo e para a direita, à velocidade SPEED; o espaço para-o; as outras teclas não mudam nada.
fun Dot.steer(key: Char): Dot {
	return this // TODO
}

// 4. O deslocamento para ir de from até to numa só coordenada: SPEED se to for maior do que from,
//    -SPEED se for menor e 0 se forem iguais.
fun direction(from: Int, to: Int): Int {
	return 0 // TODO
}

// 5. O ponto depois de um clique em target: passa a andar na direção do clique, na horizontal e na vertical.
//    Usar direction.
fun Dot.aimAt(target: Point): Dot {
	return this // TODO
}

// 6. O rasto com p no fim; se ficar com mais de max posições, sem a primeira (a mais antiga).
fun List<Point>.addLimited(p: Point, max: Int): List<Point> {
	return this // TODO
}

// 7. O mundo na imagem seguinte: o ponto avança (com bounce) e a sua posição nova entra no rasto,
//    que fica com TRAIL_SIZE posições no máximo. Usar bounce e addLimited.
fun World.tick(): World {
	return this // TODO
}

// ---------------------------------------------------------------- os testes (na consola)

// Any: um valor de qualquer tipo (Int, Dot, List<Point>, ...).
fun check(name: String, expected: Any, obtained: Any) {
	val mark = if (expected == obtained) "certo" else "ERRADO"
	println("$name: esperado $expected, obtido $obtained -> $mark")
}

// Os valores esperados contam com WIDTH = 600, HEIGHT = 300, RADIUS = 10 e SPEED = 3.
fun checks() {
	check("1. move", Dot(103, 47, 3, -3), Dot(100, 50, 3, -3).move())
	check("2. bounce no meio", Dot(303, 153, 3, 3), Dot(300, 150, 3, 3).bounce())
	check("2. bounce na parede da direita",Dot(586, 150, -3, 0), Dot(589, 150, 3, 0).bounce())
	check("2. bounce na parede de cima",Dot(100, 15, 0, 3), Dot(100, 12, 0, -3).bounce())
	check("2. bounce no canto", Dot(586, 286, -3, -3), Dot(589, 289, 3, 3).bounce())
	check("3. steer('a')", Dot(100, 100, -3, 0), Dot(100, 100, 3, 3).steer('a'))
	check("3. steer('w')", Dot(100, 100, 0, -3), Dot(100, 100, 3, 3).steer('w'))
	check("3. steer(' ')", Dot(100, 100, 0, 0), Dot(100, 100, 3, 3).steer(' '))
	check("3. steer('x')", Dot(100, 100, 3, 3), Dot(100, 100, 3, 3).steer('x'))
	check("4. direction(10, 50)", 3, direction(10, 50))
	check("4. direction(50, 10)", -3, direction(50, 10))
	check("4. direction(7, 7)", 0, direction(7, 7))
	check("5. aimAt", Dot(100, 100, -3, 3), Dot(100, 100, 3, 0).aimAt(Point(20, 250)))
	check("5. aimAt na mesma linha", Dot(100, 100, 3, 0), Dot(100, 100, 0, -3).aimAt(Point(400, 100)))
	val a = Point(1, 1)
	val b = Point(2, 2)
	val c = Point(3, 3)
	check("6. addLimited sem passar", listOf(a, b, c), listOf(a, b).addLimited(c, 3))
	check("6. addLimited a passar", listOf(b, c), listOf(a, b).addLimited(c, 2))
	check("6. addLimited vazia", listOf(c), listOf<Point>().addLimited(c, 2))
	check("7. tick", World(Dot(103, 100, 3, 0), listOf(Point(103, 100))), World(Dot(100, 100, 3, 0), listOf()).tick())
}

// ---------------------------------------------------------------- a janela (já está feita)

fun Canvas.drawWorld(w: World) {
	erase()
	w.trail.forEach { drawCircle(it.x, it.y, RADIUS / 2, TRAIL_COLOR) }
	drawCircle(w.dot.x, w.dot.y, RADIUS, DOT_COLOR)
}

fun main(){
	checks()
	onStart {
		val arena = Canvas(WIDTH, HEIGHT, BLACK)
		var world = World(Dot(WIDTH / 2, HEIGHT / 2, SPEED, SPEED), listOf())   // o único var
		arena.onKeyPressed { k -> world = world.copy(dot = world.dot.steer(k.char)) }
		arena.onMouseDown { me -> world = world.copy(dot = world.dot.aimAt(Point(me.x, me.y))) }
		arena.onTimeProgress(PERIOD) {
			world = world.tick()
			arena.drawWorld(world)
		}
	}
	onFinish { }
}
