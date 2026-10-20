// Programação (PG) — Aula 8: Listas  (exercícios)
// Completar as funções marcadas com TODO. Cada uma devolve, para já, um valor fixo para o ficheiro compilar.
// O main mostra, para cada exercício, o valor esperado e o valor obtido.
// Alguns testes podem dar certo por acaso antes de a função estar feita: o objetivo é ficarem todos certos.
// Regra: não usar funções da biblioteca que já resolvam o exercício (reversed, sorted, indexOf, ...);
//        filter e map só nos exercícios 6 e 7, onde se pedem.
// Correr:  kotlinc exercicios_listas.kt   e depois   kotlin Exercicios_listasKt

// 1. O elemento do meio da lista (a lista tem um número ímpar de elementos).
fun middle(list: List<Int>): Int {
	return 0 // TODO
}

// 2. O dia em que a temperatura foi value (o primeiro, se houver vários), ou "nenhum".
//    days e temps estão ligadas pelo mesmo índice: temps[i] é a temperatura do dia days[i].
fun dayOf(days: List<String>, temps: List<Int>, value: Int): String {
	return "" // TODO
}

// 3. Uma lista nova com os mesmos elementos, pela ordem inversa.
fun reverse(list: List<Int>): List<Int> {
	return listOf() // TODO
}

// 4. true se cada elemento for maior ou igual ao anterior (uma lista vazia está ordenada).
fun isSorted(list: List<Int>): Boolean {
	return false // TODO
}

// 5. A variação de cada dia para o seguinte: temps[i + 1] - temps[i].
//    A lista resultante tem menos um elemento do que temps.
fun changes(temps: List<Int>): List<Int> {
	return listOf() // TODO
}

// 6. A sigla: a primeira letra, em maiúscula, de cada palavra com mais de 2 letras.
//    Usar filter para ficar só com essas palavras.
fun acronym(words: List<String>): String {
	return "" // TODO
}

// 7. O comprimento das palavras que começam por uma letra maiúscula.
//    Escrever numa só expressão, com filter e map.
fun upperLengths(words: List<String>): List<Int> {
	return listOf() // TODO
}

// Any: um valor de qualquer tipo (Int, Boolean, String, List<Int>, ...).
fun check(name: String, expected: Any, obtained: Any) {
	val mark = if (expected == obtained) "certo" else "ERRADO"
	println("$name: esperado $expected, obtido $obtained -> $mark")
}

fun main(){
	val days = listOf("seg", "ter", "qua", "qui", "sex", "sáb", "dom")
	val temps = listOf(14, 17, 21, 19, 12, 9, 16)       // temperaturas máximas da semana, em °C
	val words = listOf("Instituto", "Superior", "de", "Engenharia", "de", "Lisboa")

	check("1. middle(temps)", 19, middle(temps))
	check("1. middle(listOf(5))", 5, middle(listOf(5)))
	check("2. dayOf(days, temps, 12)", "sex", dayOf(days, temps, 12))
	check("2. dayOf(days, temps, 30)", "nenhum", dayOf(days, temps, 30))
	check("3. reverse(listOf(1, 2, 3))", listOf(3, 2, 1), reverse(listOf(1, 2, 3)))
	check("3. reverse(temps)", listOf(16, 9, 12, 19, 21, 17, 14), reverse(temps))
	check("3. reverse(listOf())", listOf<Int>(), reverse(listOf()))
	check("4. isSorted(listOf(1, 2, 2, 5))", true, isSorted(listOf(1, 2, 2, 5)))
	check("4. isSorted(temps)", false, isSorted(temps))
	check("4. isSorted(listOf())", true, isSorted(listOf()))
	check("5. changes(temps)", listOf(3, 4, -2, -7, -3, 7), changes(temps))
	check("5. changes(listOf(8))", listOf<Int>(), changes(listOf(8)))
	check("6. acronym(words)", "ISEL", acronym(words))
	check("6. acronym(world wide web)", "WWW", acronym(listOf("world", "wide", "web")))
	check("7. upperLengths(words)", listOf(9, 8, 10, 6), upperLengths(words))
}
