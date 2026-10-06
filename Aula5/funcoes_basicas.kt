// Programação (PG) — Aula 5: Funções
// Demonstra: definir e chamar funções, parâmetros e retorno, função = expressão.
// Correr:  kotlinc funcoes_basicas.kt   e depois   kotlin Funcoes_basicasKt

// Função com parâmetros e tipo de retorno (corpo em bloco).
fun squareArea(side: Double): Double {
	return side * side
}

// Função = expressão: o corpo é uma única expressão, o tipo de retorno é inferido.
fun cubeVolume(side: Double) = squareArea(side) * side

// Função que devolve Boolean (pura: o resultado depende só dos argumentos).
fun isEven(n: Int) = n % 2 == 0

// Função com if como expressão.
fun max(a: Int, b: Int) = if (a > b) a else b

// Função sem retorno útil (Unit): só escreve no ecrã (impura).
fun showTitle(text: String) {
	println("=== $text ===")
}

fun main(){
	showTitle("Geometria")
	println("Área do quadrado de lado 3.0: ${squareArea(3.0)}")
	println("Volume do cubo de lado 3.0: ${cubeVolume(3.0)}")

	showTitle("Números")
	println("8 é par? ${isEven(8)}")
	println("7 é par? ${isEven(7)}")
	println("Maior de 12 e 5: ${max(12, 5)}")
}
