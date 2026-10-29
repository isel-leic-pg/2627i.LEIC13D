// Programação (PG) — Aula 9: Funções extensão e listas
// Demonstra: funções extensão de tipos simples (Int, Char, String), o recetor e o this,
//            e a comparação com uma função normal.
// Correr:  kotlinc extensoes.kt   e depois   kotlin ExtensoesKt

// Função normal: o valor é um parâmetro.
fun isEvenNumber(n: Int) = n % 2 == 0

// Função extensão de Int: o valor é o recetor (this).
// Nota: não pode existir também fun isEven(n: Int) neste ficheiro: para a JVM seriam a mesma função.
fun Int.isEven() = this % 2 == 0

fun Int.square() = this * this
fun Int.isMultipleOf(d: Int) = this % d == 0       // extensão com um parâmetro
fun Char.isVowel() = this in "aeiouAEIOU"
fun String.isLong() = length > 10                   // o mesmo que this.length > 10

fun String.countVowels(): Int {
	var count = 0
	for (c in this)                                 // aqui o this é indispensável
		if (c.isVowel()) count++
	return count
}

fun main(){
	println(isEvenNumber(7))           // false (função normal)
	println(7.isEven())                // false (função extensão)
	println(10.isEven())               // true
	println((3 + 5).isEven())          // true

	println(5.square())                // 25
	println(12.isMultipleOf(4))        // true
	println(12.isMultipleOf(5))        // false
	println('e'.isVowel())             // true
	println('k'.isVowel())             // false
	println("Kotlin".isLong())         // false
	println("Programação".isLong())    // true (11 carateres)
	println("Kotlin".countVowels())    // 2

	// Também funciona com variáveis e com o resultado de outras funções.
	val n = 6
	println(n.square().isEven())       // true (36 é par)
}
