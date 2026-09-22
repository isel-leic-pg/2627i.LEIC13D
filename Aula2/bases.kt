// Programação (PG) — Aula 2: Tipos e valores
// Demonstra: literais em hexadecimal e binário, separador _ e representação noutra base.
// Correr:  kotlinc bases.kt   e depois   kotlin BasesKt

fun main(){
	// O MESMO valor (255) escrito em bases diferentes:
	val decimal = 255
	val hex = 0xFF           // prefixo 0x -> hexadecimal
	val bin = 0b1111_1111    // prefixo 0b -> binário (o _ só ajuda a ler)

	println(decimal)   // 255
	println(hex)       // 255
	println(bin)       // 255

	// O separador _ pode agrupar dígitos de números grandes.
	val umMilhao = 1_000_000
	println(umMilhao)  // 1000000

	// Representar um inteiro NOUTRA base com toString(base):
	val n = 255
	println(n.toString(2))    // 11111111   (binário)
	println(n.toString(16))   // ff          (hexadecimal)
}
