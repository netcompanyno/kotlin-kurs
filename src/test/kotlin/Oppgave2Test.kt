import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Oppgave2Test {

    @Test
    fun `Person("Ola") skal ha name = Ola`() {
        val ola = Person("Ola")

        assertEquals("Ola", ola.name)
    }

    @Test
    fun `Person("Ola") skal være lik Person("Ola")`() {
        assertEquals(Person("Ola"), Person("Ola"))
    }

    @Test
    fun `ola + kari == sant skal gi true`() {
        val ola = Person("Ola")
        val kari = Person("Kari")
        val sant = Couple(ola, kari)

        assertEquals(ola + kari, sant)
    }

}