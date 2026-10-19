// Programação (PG) — Aula 7: Funções como valores e lambdas
// Demonstra: repeat, uma função da biblioteca cujo último parâmetro é uma lambda,
//            e o it como número da volta (0, 1, ..., n - 1).
// Nota: no fim lê um número da consola (escrever e carregar em Enter).
// Correr:  kotlinc repeat.kt   e depois   kotlin RepeatKt

// repeat também se pode usar dentro das nossas funções.
fun line(size: Int, c: Char = '-') {
	repeat(size) { print(c) }
	println()
}

fun main(){
	repeat(3) { println("Olá!") }

	// it é o número da volta: começa em 0.
	repeat(10) { print("$it ") }                         // 0 1 2 3 4 5 6 7 8 9
	println()

	line(20)                                             // --------------------
	line(20, '=')                                        // ====================

	// Tabuada do 7: como it vai de 0 a 9, usa-se it + 1.
	repeat(10) { println("7 x ${it + 1} = ${7 * (it + 1)}") }

	// O mesmo resultado com um for, para comparar.
	for (i in 1..10) print("${7 * i} ")
	println()

	// Contagem decrescente: n - it vai de n até 1.
	print("Contar a partir de? ")
	val n = readln().toInt()
	repeat(n) { print("${n - it} ") }
	println("Fim!")
}
