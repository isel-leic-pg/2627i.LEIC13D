// Programação (PG) — Aula 1: Introdução
// Demonstra: diferença entre print (não muda de linha) e println (muda de linha).
// Correr:  kotlinc print_vs_println.kt   e depois   kotlin Print_vs_printlnKt

fun main(){
	// print NÃO muda de linha: fica tudo na mesma linha.
	print("A")
	print("B")
	print("C")
	println()            // println sem texto -> apenas muda de linha

	// println muda de linha no fim: cada um fica em sua linha.
	println("A")
	println("B")
	println("C")
}
