// Programação (PG) — Aula 14: Tipos anuláveis  (exercícios)
// Um pequeno parque de estacionamento: em cada lugar está um carro ou nenhum.
// Completar as funções marcadas com TODO. Cada uma devolve, para já, um valor fixo para o ficheiro compilar.
// O main mostra, para cada exercício, o valor esperado e o valor obtido.
// Alguns testes podem dar certo por acaso antes de a função estar feita: o objetivo é ficarem todos certos.
// Regra: não usar o operador !! nem funções da biblioteca que já resolvam o exercício. Os exercícios 9 e 10 são extra.
// Correr:  kotlinc exercicios_anulaveis.kt   e depois   kotlin Exercicios_anulaveisKt

// Um lugar do parque: o número (a contar de 1) e a matrícula do carro que lá está, ou null se o lugar estiver livre.
data class Spot(val number: Int, val plate: String?)

// 1. true se o lugar estiver livre.
fun Spot.isFree(): Boolean {
	return false // TODO
}

// 2. O lugar como texto: "1: AA-01-BB", ou "2: livre" se estiver livre. Usar ?:.
fun Spot.text(): String {
	return "" // TODO
}

// 3. O mesmo lugar, depois de o carro sair. Usar copy.
fun Spot.leave(): Spot {
	return this // TODO
}

// O parque é uma lista de lugares, pela ordem dos números: o lugar 1 está no índice 0, o lugar 2 no índice 1, ...

// 4. A matrícula do carro que está no lugar com este número, ou null se o lugar estiver livre ou não existir.
//    Escrever numa só expressão, com getOrNull e ?.
fun List<Spot>.plateAt(number: Int): String? {
	return "" // TODO
}

// 5. O primeiro lugar livre, ou null se o parque estiver cheio. Usar filter e firstOrNull.
fun List<Spot>.firstFree(): Spot? {
	return Spot(0, null) // TODO
}

// 6. O número do primeiro lugar livre, ou null se o parque estiver cheio.
//    Escrever numa só expressão, com a função do exercício 5 e ?.
fun List<Spot>.firstFreeNumber(): Int? {
	return 0 // TODO
}

// 7. O número do lugar onde está o carro com esta matrícula, ou null se o carro não estiver no parque.
//    Usar um for.
fun List<Spot>.numberOf(plate: String): Int? {
	return 0 // TODO
}

// 8. As matrículas dos carros estacionados, pela ordem dos lugares.
//    Usar um for. (Com filter e map, o resultado seria uma List<String?>, e não uma List<String>.)
fun List<Spot>.plates(): List<String> {
	return listOf() // TODO
}

// ---------- Extra ----------

// 9. O lugar com o número escrito em text, que pode ter espaços à volta (" 3 "),
//    ou null se text não for um número ou se esse lugar não existir. Usar ?: return null.
fun List<Spot>.spotFromText(text: String): Spot? {
	return Spot(0, null) // TODO
}

// 10. O parque depois de o carro com esta matrícula estacionar no primeiro lugar livre,
//     ou null se o parque estiver cheio. Usar a função do exercício 6 com ?: return null, e map.
fun List<Spot>.park(plate: String): List<Spot>? {
	return this // TODO
}

// Any?: um valor de qualquer tipo (Int, Boolean, String, Spot, List<Spot>, ...) ou null.
fun check(name: String, expected: Any?, obtained: Any?) {
	val mark = if (expected == obtained) "certo" else "ERRADO"
	println("$name: esperado $expected, obtido $obtained -> $mark")
}

fun main(){
	// As matrículas são inventadas.
	val parking = listOf(
		Spot(1, "AA-01-BB"),
		Spot(2, null),
		Spot(3, "12-CD-34"),
		Spot(4, null),
		Spot(5, "56-78-EF")
	)
	val full = listOf(Spot(1, "AA-01-BB"), Spot(2, "12-CD-34"))

	check("1. Spot(2, null).isFree()", true, Spot(2, null).isFree())
	check("1. Spot(1, \"AA-01-BB\").isFree()", false, Spot(1, "AA-01-BB").isFree())
	check("2. Spot(1, \"AA-01-BB\").text()", "1: AA-01-BB", Spot(1, "AA-01-BB").text())
	check("2. Spot(2, null).text()", "2: livre", Spot(2, null).text())
	check("3. Spot(3, \"12-CD-34\").leave()", Spot(3, null), Spot(3, "12-CD-34").leave())
	check("3. Spot(2, null).leave()", Spot(2, null), Spot(2, null).leave())
	check("4. parking.plateAt(3)", "12-CD-34", parking.plateAt(3))
	check("4. parking.plateAt(2)", null, parking.plateAt(2))
	check("4. parking.plateAt(9)", null, parking.plateAt(9))
	check("5. parking.firstFree()", Spot(2, null), parking.firstFree())
	check("5. full.firstFree()", null, full.firstFree())
	check("6. parking.firstFreeNumber()", 2, parking.firstFreeNumber())
	check("6. full.firstFreeNumber()", null, full.firstFreeNumber())
	check("7. parking.numberOf(\"56-78-EF\")", 5, parking.numberOf("56-78-EF"))
	check("7. parking.numberOf(\"99-ZZ-99\")", null, parking.numberOf("99-ZZ-99"))
	check("8. parking.plates()", listOf("AA-01-BB", "12-CD-34", "56-78-EF"), parking.plates())
	check("8. sem carros", listOf<String>(), listOf(Spot(1, null)).plates())
	check("9. parking.spotFromText(\" 3 \")", Spot(3, "12-CD-34"), parking.spotFromText(" 3 "))
	check("9. parking.spotFromText(\"três\")", null, parking.spotFromText("três"))
	check("9. parking.spotFromText(\"7\")", null, parking.spotFromText("7"))
	check("10. parking.park(\"GH-90-IJ\")",
		listOf(Spot(1, "AA-01-BB"), Spot(2, "GH-90-IJ"), Spot(3, "12-CD-34"), Spot(4, null), Spot(5, "56-78-EF")),
		parking.park("GH-90-IJ"))
	check("10. full.park(\"GH-90-IJ\")", null, full.park("GH-90-IJ"))
}
