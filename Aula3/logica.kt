// Programação (PG) — Aula 3: Texto, lógica e I/O
// Demonstra: valores lógicos (Boolean), operadores && || ! e o operador in.
// Correr:  kotlinc logica.kt   e depois   kotlin LogicaKt

fun main(){
	val idade = 20

	// Uma comparação produz um Boolean (true/false):
	println(idade >= 18)          // true
	println(idade < 12)           // false

	// Operadores lógicos combinam Booleans:
	val maiorIdade = idade >= 18
	val temDesconto = idade < 12 || idade >= 65   // || = OU
	println("Maior de idade? $maiorIdade")
	println("Tem desconto? $temDesconto")

	// ! nega um Boolean:
	println(!maiorIdade)          // false

	// in verifica se um valor está dentro de um intervalo:
	println(idade in 18..65)      // true  (18 <= idade <= 65)
}
