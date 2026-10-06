// Programação (PG) — Aula 5: Funções
// Demonstra: valores por omissão e argumentos nomeados.
// Correr:  kotlinc funcoes_parametros.kt   e depois   kotlin Funcoes_parametrosKt

// O último parâmetro tem um valor por omissão: pode ser omitido na chamada.
fun greet(name: String, greeting: String = "Olá") = "$greeting, $name!"

// Vários parâmetros com valor por omissão.
fun box(text: String, border: Char = '*', width: Int = 20): String {
	val line = border.toString().repeat(width)
	return "$line\n$text\n$line"
}

fun main(){
	println(greet("Rita"))                      // usa o valor por omissão "Olá"
	println(greet("Rita", "Bom dia"))           // argumento posicional
	println(greet(greeting = "Boa tarde", name = "Rita")) // argumentos nomeados, qualquer ordem

	println(box("Programação"))
	println(box("Programação", '#'))
	println(box("Programação", width = 10))     // só altera a largura
}
