// Programação (PG) — Aula 6: Mutabilidade e ciclos
// Demonstra: uma var que guarda um intervalo (IntRange) e é reafetada a cada volta de um while.
// Nota: lê da consola — escrever um número entre 0 e 15 e carregar em Enter.
// Correr:  kotlinc intervalo_que_muda.kt   e depois   kotlin Intervalo_que_mudaKt

fun main(){
	// do-while: pedir o número até estar dentro do intervalo 0..15.
	var secret: Int
	do {
		print("Número secreto (0 a 15)? ")
		secret = readln().toInt()
	} while (secret !in 0..15)

	// A var range começa com todos os valores possíveis e vai encolhendo.
	var range = 0..15
	var tries = 0
	while (range.count() > 1) {
		val middle = (range.first + range.last) / 2
		tries++
		print("Volta $tries: range = $range, meio = $middle  ->  ")
		if (secret <= middle) range = range.first..middle     // fica a 1.ª metade
		else range = (middle + 1)..range.last                 // fica a 2.ª metade
		println("novo range = $range")
	}
	println("O número é ${range.first} (descoberto em $tries voltas)")
}
