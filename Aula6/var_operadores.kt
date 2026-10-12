// Programação (PG) — Aula 6: Mutabilidade e ciclos
// Demonstra: val vs var, afetação e operadores (+=, -=, *=, ++, --).
// Correr:  kotlinc var_operadores.kt   e depois   kotlin Var_operadoresKt

fun main(){
	val max = 10          // val: valor fixo
	// max = 20           // erro de compilação: Val cannot be reassigned
	println("max = $max")

	var x = 10            // var: variável, pode mudar (mas continua Int)
	println("x = $x")
	x = 20
	println("x = 20  -> $x")
	x += 5                // x = x + 5
	println("x += 5  -> $x")
	x -= 3                // x = x - 3
	println("x -= 3  -> $x")
	x *= 2                // x = x * 2
	println("x *= 2  -> $x")
	x /= 4                // x = x / 4  (divisão inteira)
	println("x /= 4  -> $x")
	x %= 4                // x = x % 4
	println("x %= 4  -> $x")
	x++                   // x = x + 1
	println("x++     -> $x")
	x--                   // x = x - 1
	println("x--     -> $x")

	// O tipo de uma var mantém-se: o texto só pode receber texto.
	var message = "Olá"
	message += " mundo"   // concatenação
	println(message)
}
