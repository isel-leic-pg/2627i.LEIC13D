// Programação (PG) — Aula 6: Mutabilidade e ciclos  (exemplo integrador)
// Junta: funções (Aula 5) + do-while + for + var.
// Pede uma palavra até ter o tamanho certo e conta as posições em que coincide com outra.
// Nota: lê da consola — escrever as respostas (cada uma seguida de Enter).
// Correr:  kotlinc palavras.kt   e depois   kotlin PalavrasKt

// Lê da consola até a palavra ter exatamente 'size' letras.
fun readWord(size: Int): String {
	var word: String
	do {
		print("Palavra com $size letras? ")
		word = readln().trim().uppercase()
	} while (word.length != size)
	return word
}

// Conta as posições em que as duas palavras têm a mesma letra.
fun countSamePosition(a: String, b: String): Int {
	var count = 0
	for (i in 0..<a.length)
		if (a[i] == b[i]) count++
	return count
}

fun main(){
	val secret = "SONHO"
	val guess = readWord(secret.length)
	val same = countSamePosition(secret, guess)
	println("$guess: $same letra(s) na posição certa")
}
