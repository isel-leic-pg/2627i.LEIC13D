// Programação (PG) — Aula 8: Listas
// Demonstra: criar listas (listOf) e escrevê-las; aceder (índice, size, indices, first, last);
//            percorrer com for; acumular; e os operadores +, -, in e !in.
// Correr:  kotlinc listas.kt   e depois   kotlin ListasKt

fun main(){
	// Criar e escrever
	val phrase: List<String> = listOf("uma", "frase", "é", "uma", "lista")
	val digits = listOf(3, 1, 4, 1, 5, 9, 2, 6)      // List<Int> (inferido)
	val empty = listOf<Int>()                        // lista vazia: o tipo tem de ser dito
	println(phrase)                                  // [uma, frase, é, uma, lista]
	println("digits = $digits")                      // digits = [3, 1, 4, 1, 5, 9, 2, 6]
	println(empty)                                   // []

	// Aceder: os índices vão de 0 a size - 1
	println(phrase[0])                    // uma
	println(phrase[1])                    // frase
	println(phrase.size)                  // 5
	println(phrase[phrase.size - 1])      // lista
	println(phrase.indices)               // 0..4
	println(phrase.first())               // uma
	println(phrase.last())                // lista
	// println(phrase[5])                 // erro de execução: Index 5 out of bounds for length 5

	// Percorrer: elemento a elemento ou pelos índices
	for (w in phrase) print("$w ")                          // uma frase é uma lista
	println()
	for (i in phrase.indices) print("$i:${phrase[i]} ")     // 0:uma 1:frase 2:é 3:uma 4:lista
	println()

	// Acumular: somar os elementos
	var sum = 0
	for (d in digits) sum += d
	println(sum)                          // 31

	// + e - criam listas novas: digits nunca muda
	println(digits + 7)                   // [3, 1, 4, 1, 5, 9, 2, 6, 7]
	println(digits + listOf(0, 0))        // [3, 1, 4, 1, 5, 9, 2, 6, 0, 0]
	println(digits + (7..9))              // [3, 1, 4, 1, 5, 9, 2, 6, 7, 8, 9]
	println(digits - 1)                   // [3, 4, 1, 5, 9, 2, 6]   (só a 1.ª ocorrência)
	println(digits - listOf(1, 9))        // [3, 4, 5, 2, 6]         (todas as ocorrências)
	println(digits - (1..3))              // [4, 5, 9, 6]
	println(digits)                       // [3, 1, 4, 1, 5, 9, 2, 6]
	println(9 in digits)                  // true
	println(7 !in digits)                 // true

	// Para ir juntando elementos, usa-se um var
	var squares = listOf<Int>()
	for (i in 1..5) squares = squares + i * i
	println(squares)                      // [1, 4, 9, 16, 25]
}
