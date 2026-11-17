// Programação (PG) — Aula 15: Enumerados
// Demonstra: o exemplo final dos slides, pedra, papel, tesoura na consola: um enumerado com uma propriedade,
//            converter a palavra lida numa mão (ou em null), when (this) sem else e entries.random().
// Correr:  kotlinc pedra_papel_tesoura.kt   e depois   kotlin Pedra_papel_tesouraKt

enum class Hand(val word: String) {
	ROCK("pedra"), PAPER("papel"), SCISSORS("tesoura")
}

/** A mão com este nome, ou null se não houver. */
fun handOf(word: String): Hand? {
	for (h in Hand.entries)
		if (h.word == word) return h
	return null
}

/** Esta mão vence a outra? */
fun Hand.beats(other: Hand) = when (this) {
	Hand.ROCK -> other == Hand.SCISSORS
	Hand.PAPER -> other == Hand.ROCK
	Hand.SCISSORS -> other == Hand.PAPER
}

fun main(){
	print("pedra, papel ou tesoura? ")
	val player = handOf(readln().trim().lowercase())
	if (player == null) println("Não conheço essa jogada.")
	else {
		val computer = Hand.entries.random()
		println("O computador jogou ${computer.word}.")
		println(when {
			player == computer -> "Empate."
			player.beats(computer) -> "Ganhaste!"
			else -> "Perdeste!"
		})
	}
}
