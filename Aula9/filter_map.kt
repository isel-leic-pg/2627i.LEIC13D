// Programação (PG) — Aula 9: Funções extensão e listas
// Demonstra: a nossa filter e a nossa map, escritas como funções extensão de List<Int>,
//            e qual é chamada quando o nome é igual ao da biblioteca.
// Correr:  kotlinc filter_map.kt   e depois   kotlin Filter_mapKt

// Fica só com os elementos em que keep dá true.
fun List<Int>.filter(keep: (Int) -> Boolean): List<Int> {
	var result = listOf<Int>()
	for (e in this)
		if (keep(e)) result = result + e
	return result
}

// Aplica transform a cada elemento.
fun List<Int>.map(transform: (Int) -> Int): List<Int> {
	var result = listOf<Int>()
	for (e in this) result = result + transform(e)
	return result
}

fun main(){
	val nums = listOf(3, 8, 1, 6)
	println(nums.filter { it > 3 })                  // [8, 6]
	println(nums.map { it * 10 })                    // [30, 80, 10, 60]
	println(nums.map { it % 3 })                     // [0, 2, 1, 0]
	println(nums.filter { it > 3 }.map { it * 10 })  // [80, 60]
	println(listOf<Int>().filter { it > 3 })         // []

	// Para List<Int>, neste ficheiro, são chamadas as nossas.
	// Para outros tipos continua a ser a da biblioteca:
	println(listOf("uma", "frase").filter { it.length > 3 })   // [frase]
	println("Kotlin".filter { it in "aeiou" })                  // oi
	println((1..10).filter { it % 3 == 0 })                     // [3, 6, 9]

	// Cuidado: nums.map { it.toString() } dá erro neste ficheiro,
	// porque é escolhida a nossa map, que só devolve Int.
}
