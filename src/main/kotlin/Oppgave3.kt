/**
 * Oppgave 3
 *
 * Å nei! Koden nedenfor kompilerer ikke.
 * Gjør det som skal til for at koden kompilerer, ola + kari == sant blir true, og at testene i "Oppgave3Test" kjører grønt.
 */

// Løsningsforslag oppgave 3

data class Person(val name: String)
data class Couple(val person1: Person, val person2: Person)

// En operator function som heter 'plus' kan kalles med +.
// Du kan lese mer om operator functions her: https://kotlinlang.org/docs/reference/operator-overloading.html
operator fun Person.plus(other: Person): Couple = Couple(this, other)

fun main() {

    val ola = Person(name = "Ola")
    val kari = Person(name = "Kari")
    val sant = Couple(ola, kari)

    println(ola + kari == sant)

}