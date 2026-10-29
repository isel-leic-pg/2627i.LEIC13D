// Programação (PG) — Aula 7: Funções como valores e lambdas
// Demonstra: tipos de função, o operador ::, variáveis que guardam funções e funções como parâmetro.
// Correr:  kotlinc funcoes_como_valores.kt   e depois   kotlin Funcoes_como_valoresKt

// Duas funções com a mesma assinatura: ambas são do tipo (Char) -> Char.
fun upperCase(c: Char): Char = if (c in 'a'..'z') c - ('a' - 'A') else c
fun lowerCase(c: Char): Char = if (c in 'A'..'Z') c + ('a' - 'A') else c

// Duas funções do tipo (Int) -> Int.
fun twice(n: Int): Int = n * 2
fun square(n: Int): Int = n * n

// O parâmetro fx é uma função: quem chama escolhe o que acontece a cada letra.
fun printInFx(txt: String, fx: (Char) -> Char) {
	for (c in txt) print(fx(c))
	println()
}

// Aplica a função fx a cada valor do intervalo e escreve os resultados.
fun printTable(range: IntRange, fx: (Int) -> Int) {
	for (x in range) print("${fx(x)} ")
	println()
}

fun main(){
	// Uma variável que guarda uma função (e não o resultado de a chamar).
	var fx: (Char) -> Char = ::upperCase
	println(fx('h'))                         // H
	fx = ::lowerCase                         // agora fx refere lowerCase
	println(fx('M'))                         // m

	// Sem :: a função é chamada; com :: é usada como valor.
	val c: Char = upperCase('k')             // c é um Char
	val f: (Char) -> Char = ::upperCase      // f é uma função
	println("$c ${f('k')}")                  // K K

	// Uma só função printInFx, com comportamentos diferentes.
	printInFx("AbCd", ::lowerCase)           // abcd
	printInFx("AbCd", ::upperCase)           // ABCD

	printTable(1..5, ::twice)                // 2 4 6 8 10
	printTable(1..5, ::square)               // 1 4 9 16 25
}
