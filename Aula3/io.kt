// Programação (PG) — Aula 3: Texto, lógica e I/O
// Demonstra: ler do teclado com readln() e converter com toInt()/toDouble().
// Nota: lê da consola — escrever as respostas (cada uma seguida de Enter).
// Correr:  kotlinc io.kt   e depois   kotlin IoKt

fun main(){
	print("Como te chamas? ")
	val nome = readln()

	print("Que idade tens? ")
	val idade = readln().toInt()          // texto -> Int

	print("Quanto medes (em metros)? ")
	val altura = readln().toDouble()      // texto -> Double

	val maiorIdade = idade >= 18

	println()
	println("Olá, $nome!")
	println("Daqui a 10 anos terás ${idade + 10} anos.")
	println("Medes $altura m.")
	println("Maior de idade? $maiorIdade")
}
