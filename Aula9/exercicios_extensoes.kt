// Programação (PG) — Aula 9: Funções extensão e listas  (exercícios)
// Completar as funções marcadas com TODO. Cada uma devolve, para já, um valor fixo para o ficheiro compilar.
// O main mostra, para cada exercício, o valor esperado e o valor obtido.
// Alguns testes podem dar certo por acaso antes de a função estar feita: o objetivo é ficarem todos certos.
// Regra: não usar sum(), max(), count(), filter, map nem indexOf da biblioteca (exceto onde se pede, nos exercícios 6 e 9).
// Os exercícios 7 a 10 são extra, para quem acabar os primeiros.
// Correr:  kotlinc exercicios_extensoes.kt   e depois   kotlin Exercicios_extensoesKt

// 1. Um número é primo se for maior que 1 e só for divisível por 1 e por si próprio.
fun Int.isPrime(): Boolean {
	return false // TODO
}

// 2. Soma de todos os elementos da lista.
fun List<Int>.total(): Int {
	return 0 // TODO
}

// 3. O maior elemento da lista (a lista não está vazia).
fun List<Int>.maxValue(): Int {
	return 0 // TODO
}

// 4. Quantos elementos passam no teste.
fun List<Int>.howMany(test: (Int) -> Boolean): Int {
	return 0 // TODO
}

// 5. Os índices onde aparece value.
fun List<Int>.positionsOf(value: Int): List<Int> {
	return listOf() // TODO
}

// 6. Soma dos quadrados dos números pares da lista.
//    Escrever numa só expressão com filter, map e total (podem ser as da biblioteca ou as da aula).
fun List<Int>.sumOfEvenSquares(): Int {
	return 0 // TODO
}

// ---------- Extra ----------

// 7. O fatorial: 5! = 1 * 2 * 3 * 4 * 5 = 120, e 0! = 1.
fun Int.factorial(): Int {
	return 0 // TODO
}

// 8. A potência: o número multiplicado por si próprio e vezes (e >= 0).
fun Int.pow(e: Int): Int {
	return 0 // TODO
}

// 9. Os divisores do número (positivo), por ordem.
//    Escrever numa só expressão, com um intervalo e filter.
//    Atenção: dentro da lambda, this é o número (o recetor) e it é cada elemento do intervalo.
fun Int.divisors(): List<Int> {
	return listOf() // TODO
}

// 10. Quantas palavras tem o texto (as palavras estão separadas por um ou mais espaços).
//     Dica: começa uma palavra em cada carater que não é espaço e é o primeiro ou vem a seguir a um espaço.
fun String.countWords(): Int {
	return 0 // TODO
}

// Any: um valor de qualquer tipo (Int, Boolean, List<Int>, ...).
fun check(name: String, expected: Any, obtained: Any) {
	val mark = if (expected == obtained) "certo" else "ERRADO"
	println("$name: esperado $expected, obtido $obtained -> $mark")
}

fun main(){
	val nums = listOf(3, 8, 1, 6)
	check("1. 7.isPrime()", true, 7.isPrime())
	check("1. 12.isPrime()", false, 12.isPrime())
	check("1. 1.isPrime()", false, 1.isPrime())
	check("2. total", 18, nums.total())
	check("3. maxValue", 8, nums.maxValue())
	check("3. maxValue com negativos", -1, listOf(-5, -1, -9).maxValue())
	check("4. howMany { it > 2 }", 3, nums.howMany { it > 2 })
	check("5. positionsOf(1)", listOf(1, 3), listOf(3, 1, 4, 1, 5).positionsOf(1))
	check("5. positionsOf(7)", listOf<Int>(), listOf(3, 1, 4, 1, 5).positionsOf(7))
	check("6. sumOfEvenSquares", 100, nums.sumOfEvenSquares())
	println("Extra:")
	check("7. 5.factorial()", 120, 5.factorial())
	check("7. 0.factorial()", 1, 0.factorial())
	check("8. 2.pow(10)", 1024, 2.pow(10))
	check("8. 7.pow(0)", 1, 7.pow(0))
	check("9. 12.divisors()", listOf(1, 2, 3, 4, 6, 12), 12.divisors())
	check("9. 7.divisors()", listOf(1, 7), 7.divisors())
	check("10. countWords", 5, "uma frase é uma lista".countWords())
	check("10. countWords com espaços a mais", 2, "  duas    palavras ".countWords())
	check("10. countWords de \"\"", 0, "".countWords())
}
