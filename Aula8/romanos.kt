// Programação (PG) — Aula 8: Listas
// Demonstra: duas listas ligadas pelo mesmo índice (texto de apoio, listagem 8.1)
//            e uma função que percorre os índices e sai com return quando encontra.
// Correr:  kotlinc romanos.kt   e depois   kotlin RomanosKt

val romanLetters = listOf('M', 'D', 'C', 'L', 'X', 'V', 'I')
val romanValues = listOf(1000, 500, 100, 50, 10, 5, 1)

// 'X' está no índice 4 de romanLetters e o seu valor, 10, no índice 4 de romanValues.
fun letterToValue(letter: Char): Int {
	for (i in romanLetters.indices)
		if (letter == romanLetters[i]) return romanValues[i]
	return 0      // não é uma letra romana
}

// Versão simplificada: soma o valor de cada letra e não trata a subtração (XXIX devia dar 29).
fun romanToInt(roman: String): Int {
	var number = 0
	for (r in roman) number += letterToValue(r)
	return number
}

fun main(){
	println(letterToValue('X'))       // 10
	println(letterToValue('K'))       // 0
	println(romanToInt("MMXXVI"))     // 2026
	println(romanToInt("XXIX"))       // 31 (devia ser 29)

	print("Número romano? ")
	val roman = readln().trim().uppercase()
	println("$roman = ${romanToInt(roman)}")
}
