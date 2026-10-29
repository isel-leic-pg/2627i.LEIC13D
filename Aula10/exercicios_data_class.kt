// Programação (PG) — Aula 10: Tipos agregados (data class)  (exercícios)
// Completar as funções marcadas com TODO. Cada uma devolve, para já, um valor fixo para o ficheiro compilar.
// O main mostra, para cada exercício, o valor esperado e o valor obtido.
// Alguns testes podem dar certo por acaso antes de a função estar feita: o objetivo é ficarem todos certos.
// Regra: não usar funções da biblioteca que já resolvam o exercício (padStart, sum, sumOf, ...);
//        filter e map só no exercício 8, onde se pedem. Os exercícios 9 e 10 são extra.
// Correr:  kotlinc exercicios_data_class.kt   e depois   kotlin Exercicios_data_classKt

const val MINUTES_PER_HOUR = 60
const val MINUTES_PER_DAY = 24 * MINUTES_PER_HOUR

// Uma hora do dia, de 00:00 a 23:59.
data class Time(val hours: Int, val minutes: Int)

// Uma marcação na agenda: o título, a hora de início e a duração em minutos.
data class Appointment(val title: String, val start: Time, val duration: Int)

// 1. Os minutos passados desde a meia-noite: 09:05 são 9 * 60 + 5 = 545.
fun Time.toMinutes(): Int {
	return 0 // TODO
}

// 2. O inverso: a hora do dia que corresponde a este número de minutos desde a meia-noite (de 0 a 1439).
fun Int.toTime(): Time {
	return Time(0, 0) // TODO
}

// 3. A hora passados extra minutos. Depois das 23:59 volta às 00:00.
//    Usar as duas funções anteriores.
fun Time.later(extra: Int): Time {
	return this // TODO
}

// 4. true se esta hora for antes de other (uma hora não é antes de si própria).
fun Time.isBefore(other: Time): Boolean {
	return false // TODO
}

// 5. A hora como texto, com dois algarismos nas horas e nos minutos: "09:05".
//    Dica: uma função auxiliar que escreve um Int com dois algarismos.
fun Time.text(): String {
	return "" // TODO
}

// 6. A hora a que a marcação acaba.
fun Appointment.end(): Time {
	return start // TODO
}

// 7. A mesma marcação, adiada extra minutos. Usar copy.
fun Appointment.postpone(extra: Int): Appointment {
	return this // TODO
}

// 8. Os títulos das marcações que começam antes de t.
//    Escrever numa só expressão, com filter e map.
fun List<Appointment>.titlesBefore(t: Time): List<String> {
	return listOf() // TODO
}

// ---------- Extra ----------

// 9. O total de minutos ocupados pelas marcações da lista.
fun List<Appointment>.totalMinutes(): Int {
	return 0 // TODO
}

// 10. true se alguma marcação ainda não tiver acabado quando a seguinte começa.
//     As marcações estão ordenadas pela hora de início e acabam todas no mesmo dia.
fun List<Appointment>.hasOverlap(): Boolean {
	return false // TODO
}

// Any: um valor de qualquer tipo (Int, Boolean, String, Time, List<String>, ...).
fun check(name: String, expected: Any, obtained: Any) {
	val mark = if (expected == obtained) "certo" else "ERRADO"
	println("$name: esperado $expected, obtido $obtained -> $mark")
}

fun main(){
	val t = Time(9, 5)
	val pg = Appointment("PG", Time(9, 0), 120)
	val study = Appointment("Estudo", Time(12, 30), 90)
	val library = Appointment("Biblioteca", Time(13, 0), 60)
	val day = listOf(pg, study, library)       // ordenadas pela hora de início

	check("1. Time(9, 5).toMinutes()", 545, t.toMinutes())
	check("1. Time(0, 0).toMinutes()", 0, Time(0, 0).toMinutes())
	check("2. 545.toTime()", Time(9, 5), 545.toTime())
	check("2. 1439.toTime()", Time(23, 59), 1439.toTime())
	check("3. Time(9, 5).later(70)", Time(10, 15), t.later(70))
	check("3. Time(23, 30).later(45)", Time(0, 15), Time(23, 30).later(45))
	check("4. Time(9, 5).isBefore(Time(10, 0))", true, t.isBefore(Time(10, 0)))
	check("4. Time(10, 0).isBefore(Time(9, 5))", false, Time(10, 0).isBefore(t))
	check("4. Time(9, 5).isBefore(Time(9, 5))", false, t.isBefore(Time(9, 5)))
	check("5. Time(9, 5).text()", "09:05", t.text())
	check("5. Time(14, 30).text()", "14:30", Time(14, 30).text())
	check("6. pg.end()", Time(11, 0), pg.end())
	check("6. a passar a meia-noite", Time(0, 30), Appointment("Filme", Time(22, 45), 105).end())
	check("7. pg.postpone(30)", Appointment("PG", Time(9, 30), 120), pg.postpone(30))
	check("7. pg continua igual", Time(9, 0), pg.start)
	check("8. day.titlesBefore(Time(13, 0))", listOf("PG", "Estudo"), day.titlesBefore(Time(13, 0)))
	check("8. day.titlesBefore(Time(8, 0))", listOf<String>(), day.titlesBefore(Time(8, 0)))
	check("9. day.totalMinutes()", 270, day.totalMinutes())
	check("10. day.hasOverlap()", true, day.hasOverlap())
	check("10. sem o estudo", false, listOf(pg, library).hasOverlap())
}
