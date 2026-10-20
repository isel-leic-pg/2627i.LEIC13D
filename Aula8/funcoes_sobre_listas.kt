// Programação (PG) — Aula 8: Listas
// Demonstra: forEach, filter e map em listas, intervalos e String; como poderiam estar
//            definidas com um for (forEachWord e filterWords); e filter e map em cadeia.
// Correr:  kotlinc funcoes_sobre_listas.kt   e depois   kotlin Funcoes_sobre_listasKt

// Como a forEach poderia estar definida (só para listas de String).
fun forEachWord(ws: List<String>, action: (String) -> Unit) {
	for (w in ws) action(w)
}

// Como a filter poderia estar definida (só para listas de String): um ciclo, um if e um +.
fun filterWords(words: List<String>, keep: (String) -> Boolean): List<String> {
	var result = listOf<String>()
	for (w in words)
		if (keep(w)) result = result + w
	return result
}

fun main(){
	val phrase = listOf("uma", "frase", "é", "uma", "lista")
	val digits = listOf(3, 1, 4, 1, 5, 9, 2, 6)

	// forEach: uma ação para cada elemento, que fica em it
	phrase.forEach { print("[$it]") }              // [uma][frase][é][uma][lista]
	println()
	(1..5).forEach { print("${it * it} ") }        // 1 4 9 16 25
	println()
	"PG".forEach { println(it.code) }              // 80 e 71, um por linha
	forEachWord(phrase) { print("[$it]") }         // [uma][frase][é][uma][lista]
	println()

	// filter: ficam os elementos em que o teste dá true, pela mesma ordem
	println(digits.filter { it % 2 == 0 })              // [4, 2, 6]
	println(phrase.filter { it.length > 3 })            // [frase, lista]
	println((1..10).filter { it % 3 == 0 })             // [3, 6, 9]
	println("Kotlin".filter { it in "aeiou" })          // oi  (numa String dá uma String)
	println(filterWords(phrase) { it.length > 3 })      // [frase, lista]
	println(digits)                                     // a original não muda

	// map: transforma cada elemento; o resultado tem o mesmo tamanho
	println(phrase.map { it.length })              // [3, 5, 1, 3, 5]  (de List<String> para List<Int>)
	println(digits.map { it * 2 })                 // [6, 2, 8, 2, 10, 18, 4, 12]
	println((1..5).map { it * it })                // [1, 4, 9, 16, 25]
	println("Kotlin".map { it.code })              // [75, 111, 116, 108, 105, 110]

	// Em cadeia: cada passo devolve uma lista nova; a ordem dos passos conta
	println(digits.filter { it > 3 }.map { it * 2 })                    // [8, 10, 18, 12]
	println(digits.map { it * 2 }.filter { it > 3 })                    // [6, 8, 10, 18, 4, 12]
	println(phrase.filter { it.length > 3 }.map { it.uppercase() })     // [FRASE, LISTA]
}
