// Programação (PG) — Aula 5: Funções
// Demonstra: funções sobre Char e String (junta a Aula 3 com funções) e I/O na main.
// Correr:  kotlinc funcoes_texto.kt   e depois   kotlin Funcoes_textoKt

// Compara dois símbolos: devolve '+' se forem iguais, '_' se forem diferentes.
fun compare(a: Char, b: Char) = if (a == b) '+' else '_'

fun isVowel(c: Char) = c.lowercaseChar() in "aeiou"

// A palavra tem exatamente o tamanho pedido?
fun hasLength(word: String, size: Int) = word.length == size

// Primeira e última letra, juntas numa String.
fun ends(word: String) = "${word.first()}${word.last()}"

fun main(){
	println("compare('a','a') = ${compare('a', 'a')}")
	println("compare('a','b') = ${compare('a', 'b')}")
	println("'E' é vogal? ${isVowel('E')}")
	println("'x' é vogal? ${isVowel('x')}")

	print("Palavra? ")
	val word = readln()
	println("${word.uppercase()} tem 5 letras? ${hasLength(word, 5)}")
	println("Primeira e última letra: ${ends(word)}")
}
