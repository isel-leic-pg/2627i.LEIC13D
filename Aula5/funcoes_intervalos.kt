// Programação (PG) — Aula 5: Funções
// Demonstra: intervalos (IntRange e CharRange) como parâmetros, com valor por omissão.
// Correr:  kotlinc funcoes_intervalos.kt   e depois   kotlin Funcoes_intervalosKt

// O parâmetro r é um intervalo de símbolos (CharRange); por omissão, as maiúsculas.
fun isIn(c: Char, r: CharRange = 'A'..'Z') = c in r

// O parâmetro valid é um intervalo de inteiros (IntRange); por omissão, as notas 0..20.
fun isValidGrade(grade: Int, valid: IntRange = 0..20) = grade in valid

// O intervalo também pode devolver-se: o 2.º parâmetro é opcional.
fun classify(grade: Int, valid: IntRange = 0..20) =
	if (grade !in valid) "inválida"
	else if (grade >= 10) "aprovado"
	else "reprovado"

fun main(){
	println(isIn('Q'))                       // true  (Q está em 'A'..'Z')
	println(isIn('q'))                       // false (q está fora de 'A'..'Z')
	println(isIn('q', 'a'..'z'))             // true  (outro intervalo, posicional)
	println(isIn(r = '0'..'9', c = '7'))     // true  (argumentos nomeados, qualquer ordem)

	println(isValidGrade(15))                // true
	println(isValidGrade(25))                // false
	println(isValidGrade(150, 0..200))       // true  (outra escala de notas)

	println(classify(14))                    // aprovado
	println(classify(8))                     // reprovado
	println(classify(25))                    // inválida
	println(classify(95, valid = 0..100))    // aprovado (outra escala, nomeado)
}
