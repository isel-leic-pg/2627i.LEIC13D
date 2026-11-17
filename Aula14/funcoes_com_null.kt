// Programação (PG) — Aula 14: Tipos anuláveis
// Demonstra: funções da biblioteca que devolvem null (toIntOrNull, toDoubleOrNull, firstOrNull, lastOrNull,
//            getOrNull); uma função nossa que devolve Int?; uma propriedade anulável numa data class.
// Correr:  kotlinc funcoes_com_null.kt   e depois   kotlin Funcoes_com_nullKt

/** A posição de c em text, ou null se não existir. */
fun positionOf(text: String, c: Char): Int? {
	for (i in 0..<text.length)
		if (text[i] == c) return i
	return null                   // não encontrou
}

// Um contacto pode não ter telefone.
data class Contact(val name: String, val phone: String?)

fun Contact.phoneText(): String = phone ?: "sem telefone"

fun main(){
	// Na biblioteca: a versão normal termina com uma exceção quando não há resultado; a OrNull devolve null.
	val odds = listOf(3, 5, 7)
	val big = odds.filter { it > 9 }      // lista vazia
	val list = listOf(10, 20, 30)
	println("12a".toIntOrNull())          // null
	println("3,5".toDoubleOrNull())       // null (o separador decimal é o ponto)
	println("3.5".toDoubleOrNull())       // 3.5
	println(big.firstOrNull())            // null
	println(odds.firstOrNull())           // 3
	println(big.lastOrNull())             // null
	println(list.lastOrNull())            // 30
	println(list.getOrNull(1))            // 20
	println(list.getOrNull(5))            // null
	// println(big.first())               // termina com NoSuchElementException: List is empty.
	// println(list[5])                   // termina com ArrayIndexOutOfBoundsException
	// readlnOrNull() dá null quando o input acabou (não usado aqui, para o programa não ficar à espera).

	// Uma função nossa que devolve Int?
	println(positionOf("kotlin", 't'))    // 2
	println(positionOf("kotlin", 'x'))    // null
	val p = positionOf("kotlin", 'x')
	if (p != null) println("kotlin"[p]) else println("não existe")   // não existe
	println(positionOf("kotlin", 'n') ?: -1)   // 5
	// println("kotlin"[positionOf("kotlin", 'x')])   // não compila: o índice é Int? e não Int

	// Uma propriedade anulável
	val ana = Contact("Ana", "912345678")
	val rui = Contact("Rui", null)
	println(ana)                          // Contact(name=Ana, phone=912345678)
	println(rui)                          // Contact(name=Rui, phone=null)
	println(ana.phoneText())              // 912345678
	println(rui.phoneText())              // sem telefone
	if (ana.phone != null) println(ana.phone.length)   // 9 (smart cast numa propriedade val)
	val contacts = listOf(ana, rui)
	println(contacts.filter { it.phone != null }.map { it.name })   // [Ana]
	println(contacts.map { it.phoneText() })   // [912345678, sem telefone]
}
