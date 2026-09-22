// Programação (PG) — Aula 3: Texto, lógica e I/O
// Demonstra: String, templates ($), operações com texto, Char e raw strings.
// Correr:  kotlinc texto.kt   e depois   kotlin TextoKt

fun main(){
	val nome = "Kotlin"

	// Templates: $variavel e ${expressão} dentro da string.
	println("Linguagem: $nome")
	println("Tem ${nome.length} letras.")

	// Operações com texto:
	println(nome.uppercase())   // KOTLIN
	println(nome.lowercase())   // kotlin
	println(nome[0])            // K  (primeiro caráter — índice 0)

	// Um Char tem um código Unicode:
	val letra = 'A'
	println(letra.code)         // 65

	// Raw string (entre """ """): escreve tal e qual, em várias linhas.
	val bloco = """
		Linha 1
		Linha 2
	""".trimIndent()
	println(bloco)
}
