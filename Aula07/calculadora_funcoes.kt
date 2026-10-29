// Programação (PG) — Aula 7: Funções como valores e lambdas  (exemplo integrador)
// Junta: funções (Aula 5) + do-while (Aula 6) + funções como valores e lambdas (Aula 7).
// A calculadora da Aula 4 com outra ideia: o when escolhe uma FUNÇÃO, que depois é chamada.
// Nota: lê da consola — escrever as respostas (cada uma seguida de Enter).
// Correr:  kotlinc calculadora_funcoes.kt   e depois   kotlin Calculadora_funcoesKt

fun add(a: Int, b: Int): Int = a + b
fun sub(a: Int, b: Int): Int = a - b

// Recebe a operação como parâmetro, do tipo (Int, Int) -> Int, e escreve a conta.
fun showOp(a: Int, symbol: String, b: Int, op: (Int, Int) -> Int) {
	println("$a $symbol $b = ${op(a, b)}")
}

fun main(){
	// Lambdas com dois parâmetros, guardadas em val.
	val mul = { a: Int, b: Int -> a * b }
	val div = { a: Int, b: Int -> a / b }

	// A mesma função showOp com operações diferentes.
	showOp(6, "+", 7, ::add)                 // 6 + 7 = 13
	showOp(6, "*", 7, mul)                   // 6 * 7 = 42
	showOp(17, "%", 5) { a, b -> a % b }     // 17 % 5 = 2

	var symbol: String
	do {
		print("Operação (+, -, *, /) ou s para sair? ")
		symbol = readln().trim()
		if (symbol == "+" || symbol == "-" || symbol == "*" || symbol == "/") {
			print("Primeiro número? ")
			val a = readln().toInt()
			print("Segundo número? ")
			val b = readln().toInt()
			// when como expressão: cada ramo dá uma função, não um número.
			val op: (Int, Int) -> Int = when (symbol) {
				"+" -> ::add
				"-" -> ::sub
				"*" -> mul
				else -> div
			}
			if (symbol == "/" && b == 0) println("Não se pode dividir por 0")
			else showOp(a, symbol, b, op)
		}
	} while (symbol != "s")
}
