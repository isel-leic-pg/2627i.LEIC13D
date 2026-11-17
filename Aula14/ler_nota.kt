// Programação (PG) — Aula 14: Tipos anuláveis
// Demonstra: ler uma nota de 0 a 20 até ser válida (do-while + toIntOrNull).
//            Se o utilizador escrever texto, toIntOrNull dá null e o ciclo volta a perguntar.
// Correr:  kotlinc ler_nota.kt   e depois   kotlin Ler_notaKt

fun main(){
	var grade: Int?
	do {
		print("Nota de 0 a 20? ")
		grade = readln().trim().toIntOrNull()
	} while (grade == null || grade !in 0..20)
	println("Nota $grade: faltam ${20 - grade} para 20")   // depois do ciclo, grade é Int
}
