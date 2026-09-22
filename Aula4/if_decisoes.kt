// Programação (PG) — Aula 4: Decisões
// Demonstra: if como INSTRUÇÃO e if como EXPRESSÃO (que devolve um valor).
// Correr:  kotlinc if_decisoes.kt   e depois   kotlin If_decisoesKt

fun main(){
	val n = 7

	// if como INSTRUÇÃO: decide o que executar.
	if (n % 2 == 0) {
		println("$n é par")
	} else {
		println("$n é ímpar")
	}

	// if como EXPRESSÃO: devolve um valor (aqui o else é obrigatório).
	val a = 12
	val b = 30
	val maior = if (a > b) a else b
	println("O maior é $maior")

	// Cadeia if / else if / else:
	val x = -3
	if (x > 0) {
		println("positivo")
	} else if (x < 0) {
		println("negativo")
	} else {
		println("zero")
	}
}
