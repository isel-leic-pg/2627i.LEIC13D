// Programação (PG) — Aula 4: Decisões
// Demonstra: when com sujeito, when sem sujeito e when como expressão.
// Correr:  kotlinc when_decisoes.kt   e depois   kotlin When_decisoesKt

fun main(){
	// when COM sujeito: compara 'dia' com vários casos.
	val dia = 3
	when (dia) {
		1 -> println("Segunda")
		2 -> println("Terça")
		3 -> println("Quarta")
		4 -> println("Quinta")
		5 -> println("Sexta")
		else -> println("Fim de semana")
	}

	// when SEM sujeito: cada ramo é uma condição lógica.
	val nota = 14
	when {
		nota < 10 -> println("Reprovado")
		nota < 14 -> println("Suficiente")
		else -> println("Bom")
	}

	// when como EXPRESSÃO: devolve um valor (usa intervalos com in).
	val pontos = 85
	val escalao = when (pontos) {
		in 0..49 -> "F"
		in 50..69 -> "D"
		in 70..89 -> "B"
		else -> "A"
	}
	println("Escalão: $escalao")
}
