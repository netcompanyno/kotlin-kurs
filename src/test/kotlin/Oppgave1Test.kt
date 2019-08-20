import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals

class Oppgave1Test {

    @Test
    fun `helloWorld() uten parameter skal returnere "Hello world!"`() {
        assertEquals("Hello world!", helloWorld())
    }

    @Test
    fun `helloWorld() med parameter skal returnere "Hello " + parameter + "!"`() {
        val randomInput = Random.nextInt(0, 1000).toString()
        assertEquals("Hello " + randomInput + "!", helloWorld(randomInput))
    }

    @Test
    fun `helloWorld() sin parameter skal hete "name"`() {
        val randomInput = Random.nextInt(0, 1000).toString()
        assertEquals("Hello " + randomInput + "!", helloWorld(name = randomInput))
    }

}