// Programação (PG) — Aula 6: Mutabilidade e ciclos
// Demonstra: for sobre intervalos e texto, downTo, step, break, e return dentro de uma função.
// Correr:  kotlinc ciclos_for.kt   e depois   kotlin Ciclos_forKt

// return termina o ciclo e a função assim que a resposta é conhecida.
fun hasDigit(text: String): Boolean {
	for (c in text)
		if (c in '0'..'9') return true
	return false
}

fun main(){
	for (i in 1..5) print("$i ")                 // 1 2 3 4 5
	println()
	for (i in 10 downTo 7) print("$i ")          // 10 9 8 7
	println()
	for (i in 0..<10 step 3) print("$i ")        // 0 3 6 9
	println()
	for (c in "kotlin") print("$c-")             // k-o-t-l-i-n-
	println()

	// Acumulador: var que vai mudando dentro do ciclo.
	var sum = 0
	for (i in 1..100) sum += i
	println("Soma de 1 a 100 = $sum")

	// break: contar vogais até ao primeiro ponto final.
	val line = "Texto para contar. vogais"
	var vowels = 0
	for (c in line) {
		if (c == '.') break
		if (c in "aeiouAEIOU") vowels++
	}
	println("Vogais antes do ponto: $vowels")

	println("\"abc1\" tem dígitos? ${hasDigit("abc1")}")
	println("\"abcd\" tem dígitos? ${hasDigit("abcd")}")
}
