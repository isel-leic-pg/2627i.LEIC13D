// Programação (PG) — Aula 7: Funções como valores e lambdas
// Demonstra: expressões lambda, as simplificações (tipo omitido, lambda fora dos parênteses, it)
//            e uma lambda com várias instruções que altera um var.
// Correr:  kotlinc lambdas.kt   e depois   kotlin LambdasKt

fun upperCase(c: Char): Char = if (c in 'a'..'z') c - ('a' - 'A') else c

fun printInFx(txt: String, fx: (Char) -> Char) {
	for (c in txt) print(fx(c))
	println()
}

fun main(){
	val delta = 2
	val txt = "AbCdEfGhIJKLmnop"

	// Uma lambda guardada num val: o tipo (Char) -> Char é inferido.
	// A lambda pode usar valores do sítio onde é escrita (aqui, o delta).
	val fx = { c: Char -> upperCase(c) + delta }
	printInFx(txt, fx)                                   // CDEFGHIJKLMNOPQR

	// A mesma chamada, cada vez mais curta. Todas escrevem CDEFGHIJKLMNOPQR.
	printInFx(txt, { c: Char -> upperCase(c) + delta })  // lambda passada diretamente
	printInFx(txt, { c -> upperCase(c) + delta })        // o tipo de c já é conhecido
	printInFx(txt) { c -> upperCase(c) + delta }         // último parâmetro: fora dos parênteses
	printInFx(txt) { upperCase(it) + delta }             // um só parâmetro: it

	// Outras regras para cada letra, sem ter de definir funções com nome.
	printInFx("bom dia PG") { if (it == ' ') '_' else it }   // bom_dia_PG
	printInFx("HAL") { it + 1 }                              // IBM

	// Uma lambda com dois parâmetros: o tipo é (Int, Int) -> Int.
	val add = { a: Int, b: Int -> a + b }
	println(add(2, 3))                                   // 5

	// Várias instruções: o valor devolvido é o da última expressão.
	// A lambda escreve um ponto e altera o d de main cada vez que é chamada.
	var d = 0
	printInFx("aBc") {
		print('.')
		d++
		upperCase(it) + d
	}                                                    // .B.D.F
	println("A lambda foi chamada $d vezes")             // 3
}
