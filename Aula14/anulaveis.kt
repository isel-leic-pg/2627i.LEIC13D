// Programação (PG) — Aula 14: Tipos anuláveis
// Demonstra: um valor que pode faltar (toInt vs toIntOrNull); o tipo T? e o null; smart cast no if, no when,
//            depois de um return e à direita de && e ||; os operadores ?. , ?: e !!
// Correr:  kotlinc anulaveis.kt   e depois   kotlin AnulaveisKt

// Smart cast: depois de testar o null, o compilador trata n como Int.
fun twice(n: Int?): String =
	if (n != null) "${n * 2}"     // aqui n é Int
	else "sem valor"

fun sign(n: Int?): String = when {
	n == null -> "sem valor"
	n < 0 -> "negativo"           // aqui n já é Int
	else -> "zero ou positivo"
}

fun printHalf(text: String) {
	val n = text.toIntOrNull()
	if (n == null) return
	println(n / 2)                // daqui em diante n é Int
}

// Também à direita de && e de ||
fun isPositive(n: Int?): Boolean = n != null && n > 0
fun isMissingOrNegative(n: Int?): Boolean = n == null || n < 0

// ?. : o comprimento, ou null se text for null
fun lengthOf(text: String?): Int? = text?.length

// ?. encadeado: se text for null, o resultado é null e o resto não se faz
fun clean(text: String?): String? = text?.trim()?.uppercase()

// ?: : o comprimento, ou 0 se text for null (o resultado já é Int)
fun lengthOrZero(text: String?): Int = text?.length ?: 0

// O mesmo que printHalf, com ?: return
fun printHalfWithElvis(text: String) {
	val n = text.toIntOrNull() ?: return   // sai se não for número
	println(n / 2)                         // n é Int
}

fun main(){
	// Um valor que pode faltar
	println("12".toInt())            // 12
	println("12a".toIntOrNull())     // null
	// println("12a".toInt())        // termina com NumberFormatException: For input string: "12a"

	// O tipo T?
	val a: Int = 12
	val b: Int? = 12
	val c: Int? = null
	println("$a $b $c")              // 12 12 null
	// val d: Int = null             // não compila: null cannot be a value of a non-null type 'Int'.

	// Smart cast
	println(twice(21))               // 42
	println(twice(null))             // sem valor
	println(sign(-3))                // negativo
	println(sign(null))              // sem valor
	printHalf("21")                  // 10
	printHalf("vinte")               // (não escreve nada)
	println(isPositive(5))           // true
	println(isPositive(null))        // false
	println(isMissingOrNegative(-2)) // true

	// ?. e ?:
	println(lengthOf("kotlin"))      // 6
	println(lengthOf(null))          // null
	println(clean("  isel "))        // ISEL
	println(clean(null))             // null
	println(lengthOrZero("isel"))    // 4
	println(lengthOrZero(null))      // 0
	println("12a".toIntOrNull() ?: 0)   // 0
	printHalfWithElvis("21")         // 10
	printHalfWithElvis("vinte")      // (não escreve nada)

	// !! : evita-se
	val n: Int = "12".toIntOrNull()!!
	println(n)                       // 12
	// val m: Int = "12a".toIntOrNull()!!   // termina com NullPointerException
}
