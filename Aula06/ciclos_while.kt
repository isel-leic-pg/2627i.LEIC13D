// Programação (PG) — Aula 6: Mutabilidade e ciclos
// Demonstra: while (testa antes) e do-while (testa depois, executa pelo menos uma vez).
// Nota: lê da consola — escrever as respostas (cada uma seguida de Enter).
// Correr:  kotlinc ciclos_while.kt   e depois   kotlin Ciclos_whileKt

fun main(){
	// while: contar de 1 a 5. O corpo pode nem executar (se a condição for falsa à partida).
	var i = 1
	while (i <= 5) {
		print("$i ")
		i++               // sem isto o ciclo nunca acabava
	}
	println()

	// while: somar números lidos até aparecer 0.
	var total = 0
	print("Número (0 para terminar): ")
	var n = readln().toInt()
	while (n != 0) {
		total += n
		print("Número (0 para terminar): ")
		n = readln().toInt()
	}
	println("Soma = $total")

	// do-while: pedir até o valor ser válido. Executa sempre pelo menos uma vez.
	var age: Int
	do {
		print("Idade (0 a 120)? ")
		age = readln().toInt()
	} while (age < 0 || age > 120)
	println("Idade registada: $age")
}
