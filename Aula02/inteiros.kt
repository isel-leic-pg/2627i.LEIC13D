// Programação (PG) — Aula 2: Tipos e valores
// Demonstra: inteiros — declaração com val, aritmética, divisão inteira e prioridades.
// Correr:  kotlinc inteiros.kt   e depois   kotlin InteirosKt

fun main(){
	val a = 17
	val b = 5

	println(a + b)      // 22
	println(a - b)      // 12
	println(a * b)      // 85
	println(a / b)      // 3  -> divisão INTEIRA (trunca a parte decimal)
	println(a % b)      // 2  -> resto da divisão

	// Prioridade: * e / são calculados antes de + e -
	println(a + b * 2)      // 27  (b*2 primeiro)
	println((a + b) * 2)    // 44  (parênteses mudam a ordem)

	// val é imutável: depois de atribuído, não pode mudar.
	// b = 10   // <- descomentar dá erro de compilação
}
