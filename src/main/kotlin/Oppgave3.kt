/**
 * Oppgave 3
 *
 * Å nei! Koden nedenfor kompilerer ikke.
 * Gjør det som skal til for at koden kompilerer, ola + kari == sant blir true, og at testene i "Oppgave3Test" kjører grønt.
 */

class Person(???)
class Couple(???)

// En operator function som heter 'plus' kan kalles med +.
// Du kan lese mer om operator functions her: https://kotlinlang.org/docs/reference/operator-overloading.html
operator fun ???.plus(other: ???): ??? = TODO()

fun main() {

    val ola = Person(name = "Ola")
    val kari = Person(name = "Kari")
    val sant = Couple(ola, kari)

    println(ola + kari == sant)

}