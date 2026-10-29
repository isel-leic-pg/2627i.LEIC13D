// Programação (PG) — Aula 10: Tipos agregados (data class)
// Demonstra: composição (um Point dentro de um Circle); funções extensão de tipos agregados, com o this
//            explícito e omitido, e de Int; copy; listas de objetos com forEach, filter e map.
// Correr:  kotlinc circulos.kt   e depois   kotlin CirculosKt

// O mesmo Point do pontos.kt.
data class Point(val x: Int = 0, val y: Int = 0)

// Composição: um círculo tem um centro, que é um Point.
data class Circle(val radius: Int, val center: Point, val color: Int)

// Funções extensão de Point e de Int.
fun Point.add(p2: Point) = Point(this.x + p2.x, this.y + p2.y)    // this explícito
fun Point.mult(n: Int) = Point(x * n, y * n)                      // this omitido: x é this.x
fun Int.toPoint() = Point(this, this)

// Com uma função normal: constrói-se o Circle novo propriedade a propriedade.
fun moveCircle(circle: Circle, dx: Int, dy: Int): Circle {
	val center = circle.center.add(Point(dx, dy))
	return Circle(circle.radius, center, circle.color)
}

// Com funções extensão e copy: só se escreve o que muda.
fun Circle.move(dx: Int, dy: Int) = copy(center = center.add(Point(dx, dy)))
fun Circle.grow(n: Int) = copy(radius = radius * n)
fun Circle.diameter() = 2 * radius

fun main(){
	val c1 = Circle(12, Point(20, 15), 0x0000FF)
	println(c1)                     // Circle(radius=12, center=Point(x=20, y=15), color=255)
	println(c1.center.x)            // 20  (o x do centro de c1)

	println(Point(20, 15).add(Point(15, 10)))   // Point(x=35, y=25)
	println(Point(3, 4).mult(10))               // Point(x=30, y=40)
	println(25.toPoint())                       // Point(x=25, y=25)

	println(moveCircle(c1, 7, -3))  // Circle(radius=12, center=Point(x=27, y=12), color=255)
	println(c1.move(7, -3))         // o mesmo, com copy
	println(c1.copy(radius = 30))   // Circle(radius=30, center=Point(x=20, y=15), color=255)
	println(c1)                     // c1 não mudou: Circle(radius=12, center=Point(x=20, y=15), color=255)

	// Listas de objetos
	val circles = listOf(c1, Circle(5, Point(), 0xFF0000), Circle(40, 100.toPoint(), 0x00FF00))
	circles.forEach { println(it.diameter()) }              // 24, 10 e 80, um por linha
	println(circles.filter { it.radius > 10 }.size)        // 2
	println(circles.map { it.center })                     // [Point(x=20, y=15), Point(x=0, y=0), Point(x=100, y=100)]
	println(circles.map { it.grow(2) }.map { it.radius })  // [24, 10, 80]
}
