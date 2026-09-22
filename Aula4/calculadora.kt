// Programação (PG) — Aula 4: Decisões  (exemplo integrador)
// Demonstra: mini-calculadora — junta I/O (Aula 3) com when como expressão (Aula 4).
// Nota: lê da consola — escrever as respostas (cada uma seguida de Enter).
// Correr:  kotlinc calculadora.kt   e depois   kotlin CalculadoraKt

fun main(){
	print("Primeiro número: ")
	val a = readln().toDouble()

	print("Operação (+, -, *, /): ")
	val op = readln()

	print("Segundo número: ")
	val b = readln().toDouble()

	// when como expressão: cada ramo devolve o resultado da operação.
	val resultado = when (op) {
		"+" -> a + b
		"-" -> a - b
		"*" -> a * b
		"/" -> a / b
		else -> {
			println("Operação inválida!")
			0.0
		}
	}

	println("$a $op $b = $resultado")
}
