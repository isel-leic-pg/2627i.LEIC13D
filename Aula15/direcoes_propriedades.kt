// Programação (PG) — Aula 15: Enumerados
// Demonstra: um enumerado com propriedades (cada direção sabe o seu deslocamento); funções extensão de
//            enumerados (when (this) sem else, ou com o ordinal); um enumerado como propriedade de uma data class.
// Correr:  kotlinc direcoes_propriedades.kt   e depois   kotlin Direcoes_propriedadesKt

// No ecrã (e na CanvasLib), o y cresce para baixo: UP tem dy = -1.
enum class Dir(val dx: Int, val dy: Int) {
	UP(0, -1), RIGHT(1, 0), DOWN(0, 1), LEFT(-1, 0)
}

data class Point(val x: Int, val y: Int)

fun Point.move(d: Dir) = Point(x + d.dx, y + d.dy)

/** A direção oposta. */
fun Dir.reverse() = when (this) {
	Dir.UP -> Dir.DOWN
	Dir.RIGHT -> Dir.LEFT
	Dir.DOWN -> Dir.UP
	Dir.LEFT -> Dir.RIGHT
}

/** A direção seguinte no sentido dos ponteiros do relógio (usa a ordem da declaração). */
fun Dir.turnRight() = Dir.entries[(ordinal + 1) % Dir.entries.size]

enum class Signal { GREEN, YELLOW, RED }

/** A cor seguinte do semáforo. */
fun Signal.next() = when (this) {
	Signal.GREEN -> Signal.YELLOW
	Signal.YELLOW -> Signal.RED
	Signal.RED -> Signal.GREEN
}

/** Um robô: onde está e para onde está virado. */
data class Robot(val pos: Point, val dir: Dir)

fun Robot.step() = copy(pos = pos.move(dir))
fun Robot.turn() = copy(dir = dir.turnRight())

fun main(){
	// Propriedades
	println(Dir.LEFT.dx)                     // -1
	println(Dir.UP.dy)                       // -1
	println(Point(3, 10).move(Dir.RIGHT))    // Point(x=4, y=10)
	println(Point(3, 10).move(Dir.UP))       // Point(x=3, y=9)
	println(Dir.LEFT.name + " " + Dir.LEFT.ordinal)   // LEFT 3

	// Funções extensão
	println(Dir.UP.reverse())                // DOWN
	println(Dir.LEFT.turnRight())            // UP
	for (d in Dir.entries)
		println("$d: reverse=${d.reverse()} turnRight=${d.turnRight()}")
	var light = Signal.GREEN
	repeat(4) {
		print("$light ")
		light = light.next()
	}
	println()                                // GREEN YELLOW RED GREEN

	// Um enumerado dentro de uma data class
	var r = Robot(Point(0, 0), Dir.RIGHT)
	println(r)    // Robot(pos=Point(x=0, y=0), dir=RIGHT)
	r = r.step()
	println(r)    // Robot(pos=Point(x=1, y=0), dir=RIGHT)
	r = r.turn()
	println(r)    // Robot(pos=Point(x=1, y=0), dir=DOWN)
	r = r.step()
	println(r)    // Robot(pos=Point(x=1, y=1), dir=DOWN)
}
