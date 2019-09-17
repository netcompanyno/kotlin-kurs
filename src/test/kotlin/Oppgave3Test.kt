import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals

class Oppgave3Test {

    @Test
    fun `Dersom id er null, returner en respons med status 404`() {
        val respons = handleRemoteCall(null)
        assertEquals(Response(404), respons)
    }

    @Test
    fun `Dersom id er ikke er null, kall callRemoteAPI`() {
        val before = ignoreThis
        handleRemoteCall(5)
        val after = ignoreThis
        assertEquals(after, before + 1)
    }

    @Test
    fun `Dersom callRemoteAPI returnerer null, returner en respons med status 404`() {
        val respons = handleRemoteCall(1)
        assertEquals(Response(404), respons)
    }

    @Test
    fun `Dersom callRemoteAPI returnerer en respons med status 500, kast en exception`() {
        assertThrows<Exception> {
            handleRemoteCall(2)
        }
    }

    @Test
    fun `Ellers, returner responsen fra callRemoteAPI`() {
        val respons = handleRemoteCall(3)
        assertEquals(Response(200), respons)
    }

}