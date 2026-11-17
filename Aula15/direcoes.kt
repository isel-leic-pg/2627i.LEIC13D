// Programação (PG) — Aula 15: Enumerados
// Demonstra: declarar e usar uma enum class; when com todos os valores, sem else; name e ordinal;
//            comparar pela ordem da declaração; entries (percorrer, indexar, filter, random);
//            converter texto num enumerado com valueOf e com uma função nossa que devolve Dir?.
// Correr:  kotlinc direcoes.kt   e depois   kotlin DirecoesKt

// Declara-se fora de funções. Os valores escrevem-se em maiúsculas.
enum class Dir { UP, RIGHT, DOWN, LEFT }

// Um ramo para cada valor: não é preciso else. No ecrã, o y cresce para baixo.
fun deltaY(d: Dir) = when (d) {
	Dir.UP -> -1
	Dir.DOWN -> 1
	Dir.LEFT, Dir.RIGHT -> 0
}

/** A direção com este nome, ou null se não houver nenhuma. */
fun dirOf(name: String): Dir? {
	for (d in Dir.entries)
		if (d.name == name) return d
	return null
}

fun main(){
	// Definir e usar
	var motion = Dir.RIGHT
	println(motion)                     // RIGHT
	println(motion == Dir.LEFT)         // false
	motion = Dir.UP                     // outro valor
	println("vai para $motion")         // vai para UP
	// motion = "UP"                    // não compila: o tipo é Dir, não String

	// when
	println(deltaY(Dir.UP))             // -1
	println(deltaY(Dir.LEFT))           // 0

	// name, ordinal e a ordem da declaração
	println(Dir.LEFT.name)              // LEFT
	println(Dir.UP.ordinal)             // 0
	println(Dir.LEFT.ordinal)           // 3
	println(Dir.DOWN > Dir.UP)          // true
	println(Dir.LEFT < Dir.RIGHT)       // false

	// entries: a lista de todos os valores
	for (d in Dir.entries)
		print("$d=${d.ordinal} ")
	println()                           // UP=0 RIGHT=1 DOWN=2 LEFT=3
	println(Dir.entries)                // [UP, RIGHT, DOWN, LEFT]
	println(Dir.entries.size)           // 4
	println(Dir.entries[2])             // DOWN
	println(Dir.entries.filter { it > Dir.RIGHT })   // [DOWN, LEFT]
	println(Dir.entries.random())       // uma direção ao acaso

	// De texto para enumerado
	println(Dir.valueOf("LEFT"))        // LEFT
	// println(Dir.valueOf("left"))     // termina com IllegalArgumentException: No enum constant Dir.left
	println(dirOf("LEFT"))              // LEFT
	println(dirOf("left"))              // null
	println(dirOf("left".uppercase()))  // LEFT
	println(dirOf("norte") ?: Dir.UP)   // UP
	println(dirOf("RIGHT")?.ordinal)    // 1
}
