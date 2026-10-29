// Programação (PG) — Aula 10: Tipos agregados (data class)
// Demonstra: definir uma data class; criar objetos com argumentos posicionais, nomeados e por omissão;
//            aceder às propriedades; println e templates; comparar com ==;
//            funções que recebem e devolvem objetos; devolver dois valores de uma vez.
// Correr:  kotlinc pontos.kt   e depois   kotlin PontosKt

// Declara-se fora de main, ao nível de topo. Cada propriedade é um val, com nome e tipo.
data class Point(val x: Int = 0, val y: Int = 0)

// Somar e multiplicar vetores (texto de apoio, 7.1): devolvem um objeto novo.
fun addPoints(p1: Point, p2: Point) = Point(p1.x + p2.x, p1.y + p2.y)
fun multPoint(p: Point, n: Int) = Point(p.x * n, p.y * n)

// Uma função só devolve um valor, mas esse valor pode juntar dois: a coluna (x) e a linha (y)
// do elemento index numa grelha com width colunas, contadas a partir de 0.
fun cellOf(index: Int, width: Int) = Point(index % width, index / width)

fun main(){
	// Criar objetos
	val pt = Point(20, 15)
	println(pt)                          // Point(x=20, y=15)
	println(Point())                     // Point(x=0, y=0)      (valores por omissão)
	println(Point(y = 15, x = 20))       // Point(x=20, y=15)    (argumentos nomeados)
	println(Point(10))                   // Point(x=10, y=0)
	println(Point(y = 30))               // Point(x=0, y=30)

	// Aceder às propriedades e escrever
	println(pt.x)                        // 20
	println(pt.y)                        // 15
	println("pt = $pt")                  // pt = Point(x=20, y=15)
	println("x + y = ${pt.x + pt.y}")    // x + y = 35

	// Comparar: == compara propriedade a propriedade
	println(Point(30, 0) == Point(30))   // true
	println(Point(1, 2) == Point(2, 1))  // false

	// Um val não muda: a linha seguinte não compila ('val' cannot be reassigned).
	// pt.x = 5

	// Funções que recebem e devolvem objetos: pt continua igual
	val sum = addPoints(pt, Point(15, 10))
	println(sum)                                           // Point(x=35, y=25)
	println(multPoint(sum, 2))                             // Point(x=70, y=50)
	println(multPoint(addPoints(pt, Point(15, 10)), 2))    // Point(x=70, y=50)
	println(pt)                                            // Point(x=20, y=15)

	// Dois valores devolvidos de uma vez
	val cell = cellOf(7, 3)
	println("linha ${cell.y}, coluna ${cell.x}")           // linha 2, coluna 1
}
