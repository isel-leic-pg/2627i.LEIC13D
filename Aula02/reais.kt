// Programação (PG) — Aula 2: Tipos e valores
// Demonstra: números reais (Double), divisão real vs inteira e arredondamentos.
// Correr:  kotlinc reais.kt   e depois   kotlin ReaisKt

fun main(){
	val x = 7.0
	val y = 2.0
	println(x / y)     // 3.5  -> divisão REAL

	// Com inteiros, / é divisão inteira; basta UM operando real para ser divisão real.
	println(7 / 2)     // 3
	println(7.0 / 2)   // 3.5

	// Os reais têm precisão limitada (norma IEEE 754):
	println(0.1 + 0.2) // 0.30000000000000004  (não é exatamente 0.3!)

	// Conversões entre inteiro e real:
	val inteiro = 10
	println(inteiro.toDouble())   // 10.0
	println(3.99.toInt())         // 3   (toInt trunca, não arredonda)
}
