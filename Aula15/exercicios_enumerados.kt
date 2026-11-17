// Programação (PG) — Aula 15: Enumerados  (exercícios)
// As cartas de um baralho de sueca: 40 cartas, 10 de cada naipe.
// Completar as funções marcadas com TODO. Cada uma devolve, para já, um valor fixo para o ficheiro compilar.
// O main mostra, para cada exercício, o valor esperado e o valor obtido.
// Alguns testes podem dar certo por acaso antes de a função estar feita: o objetivo é ficarem todos certos.
// Regra: não usar funções da biblioteca que já resolvam o exercício (sum, sumOf, maxOrNull, ...).
//        Os exercícios 9 e 10 são extra.
// Correr:  kotlinc exercicios_enumerados.kt   e depois   kotlin Exercicios_enumeradosKt

// Os naipes, com o nome em português e a letra usada para os escrever.
enum class Suit(val word: String, val letter: Char) {
	CLUBS("paus", 'P'), DIAMONDS("ouros", 'O'), HEARTS("copas", 'C'), SPADES("espadas", 'E')
}

// Os valores das cartas, da mais fraca para a mais forte, com o símbolo e os pontos de cada uma.
// Na sueca, a Dama (D) vale 2 pontos, o Valete (V) 3, o Rei (R) 4, o 7 vale 10 e o Ás (A) 11; as outras não valem pontos.
enum class Rank(val symbol: Char, val points: Int) {
	TWO('2', 0), THREE('3', 0), FOUR('4', 0), FIVE('5', 0), SIX('6', 0),
	QUEEN('D', 2), JACK('V', 3), KING('R', 4), SEVEN('7', 10), ACE('A', 11)
}

// Uma carta: o valor e o naipe.
data class Card(val rank: Rank, val suit: Suit)

// 1. true se o naipe for vermelho (ouros e copas). Usar um when sem else, com dois valores em cada ramo.
fun Suit.isRed(): Boolean {
	return false // TODO
}

// 2. A carta como texto: "7 de copas", "R de espadas". Usar as propriedades dos enumerados.
fun Card.text(): String {
	return "" // TODO
}

// 3. true se esta carta vencer other: só vence se for do mesmo naipe e mais forte.
//    Os valores de um enumerado comparam-se pela ordem da declaração.
fun Card.beats(other: Card): Boolean {
	return false // TODO
}

// 4. O valor seguinte, um pouco mais forte, ou null se este for o Ás. Usar entries, ordinal e getOrNull.
fun Rank.next(): Rank? {
	return this // TODO
}

// 5. O valor com este símbolo, ou null se nenhum o tiver: rankOf('V') é Rank.JACK.
fun rankOf(symbol: Char): Rank? {
	return Rank.TWO // TODO
}

// 6. O total de pontos das cartas. Usar um for.
fun List<Card>.points(): Int {
	return 0 // TODO
}

// 7. A carta mais forte (pelo valor, sem olhar ao naipe), ou null se a lista estiver vazia.
//    Se houver duas igualmente fortes, a primeira. Usar um for.
fun List<Card>.strongest(): Card? {
	return Card(Rank.TWO, Suit.CLUBS) // TODO
}

// 8. O baralho completo, com as 40 cartas: primeiro as de paus, do 2 ao Ás, depois as de ouros, e assim por diante
//    (pela ordem de Suit.entries e de Rank.entries).
fun fullDeck(): List<Card> {
	return listOf() // TODO
}

// ---------- Extra ----------

// 9. A carta escrita em text com o símbolo do valor e a letra do naipe: "7C" é o 7 de copas, "DE" a Dama de espadas.
//    null se text não tiver 2 carateres ou se algum deles não corresponder a nada.
//    Usar a função do exercício 5 e uma função parecida para o naipe, com ?: return null.
fun cardOf(text: String): Card? {
	return Card(Rank.TWO, Suit.CLUBS) // TODO
}

// 10. true se esta carta vencer other, que foi jogada primeiro, quando o naipe trump é trunfo:
//     uma carta de trunfo vence qualquer carta que não seja de trunfo; uma carta que não é de trunfo não vence
//     uma de trunfo; nos outros casos, é como no exercício 3. Usar um when sem sujeito.
fun Card.beatsWithTrump(other: Card, trump: Suit): Boolean {
	return false // TODO
}

// Any?: um valor de qualquer tipo (Int, Boolean, String, Rank, Card, List<Card>, ...) ou null.
fun check(name: String, expected: Any?, obtained: Any?) {
	val mark = if (expected == obtained) "certo" else "ERRADO"
	println("$name: esperado $expected, obtido $obtained -> $mark")
}

fun main(){
	val sevenHearts = Card(Rank.SEVEN, Suit.HEARTS)
	val hand = listOf(Card(Rank.ACE, Suit.CLUBS), sevenHearts, Card(Rank.QUEEN, Suit.HEARTS), Card(Rank.FOUR, Suit.SPADES))
	val kings = listOf(Card(Rank.KING, Suit.HEARTS), Card(Rank.KING, Suit.SPADES), Card(Rank.JACK, Suit.CLUBS))

	check("1. Suit.HEARTS.isRed()", true, Suit.HEARTS.isRed())
	check("1. Suit.DIAMONDS.isRed()", true, Suit.DIAMONDS.isRed())
	check("1. Suit.SPADES.isRed()", false, Suit.SPADES.isRed())
	check("2. 7 de copas", "7 de copas", sevenHearts.text())
	check("2. Rei de espadas", "R de espadas", Card(Rank.KING, Suit.SPADES).text())
	check("3. Ás de copas contra 7 de copas", true, Card(Rank.ACE, Suit.HEARTS).beats(sevenHearts))
	check("3. 6 de copas contra Dama de copas", false, Card(Rank.SIX, Suit.HEARTS).beats(Card(Rank.QUEEN, Suit.HEARTS)))
	check("3. Ás de copas contra 2 de espadas", false, Card(Rank.ACE, Suit.HEARTS).beats(Card(Rank.TWO, Suit.SPADES)))
	check("4. Rank.TWO.next()", Rank.THREE, Rank.TWO.next())
	check("4. Rank.KING.next()", Rank.SEVEN, Rank.KING.next())
	check("4. Rank.ACE.next()", null, Rank.ACE.next())
	check("5. rankOf('V')", Rank.JACK, rankOf('V'))
	check("5. rankOf('7')", Rank.SEVEN, rankOf('7'))
	check("5. rankOf('K')", null, rankOf('K'))
	check("6. hand.points()", 23, hand.points())
	check("6. sem cartas", 0, listOf<Card>().points())
	check("7. hand.strongest()", Card(Rank.ACE, Suit.CLUBS), hand.strongest())
	check("7. kings.strongest()", Card(Rank.KING, Suit.HEARTS), kings.strongest())
	check("7. sem cartas", null, listOf<Card>().strongest())
	check("8. fullDeck().size", 40, fullDeck().size)
	check("8. fullDeck() na posição 0", Card(Rank.TWO, Suit.CLUBS), fullDeck().getOrNull(0))
	check("8. fullDeck() na posição 10", Card(Rank.TWO, Suit.DIAMONDS), fullDeck().getOrNull(10))
	check("8. fullDeck() na posição 39", Card(Rank.ACE, Suit.SPADES), fullDeck().getOrNull(39))
	check("8. fullDeck().points() (usa o 6)", 120, fullDeck().points())
	check("9. cardOf(\"7C\")", sevenHearts, cardOf("7C"))
	check("9. cardOf(\"DE\")", Card(Rank.QUEEN, Suit.SPADES), cardOf("DE"))
	check("9. cardOf(\"7X\")", null, cardOf("7X"))
	check("9. cardOf(\"10C\")", null, cardOf("10C"))
	check("10. 2 de espadas (trunfo) contra Ás de copas", true,
		Card(Rank.TWO, Suit.SPADES).beatsWithTrump(Card(Rank.ACE, Suit.HEARTS), Suit.SPADES))
	check("10. Ás de copas contra 2 de espadas (trunfo)", false,
		Card(Rank.ACE, Suit.HEARTS).beatsWithTrump(Card(Rank.TWO, Suit.SPADES), Suit.SPADES))
	check("10. Ás de copas contra 7 de copas", true,
		Card(Rank.ACE, Suit.HEARTS).beatsWithTrump(sevenHearts, Suit.SPADES))
	check("10. Ás de copas contra 2 de paus", false,
		Card(Rank.ACE, Suit.HEARTS).beatsWithTrump(Card(Rank.TWO, Suit.CLUBS), Suit.SPADES))
}
