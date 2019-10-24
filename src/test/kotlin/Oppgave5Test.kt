import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class Oppgave5Test {

    @Test
    fun `Dersom id er null, returner en respons med status 404`() {
        val response = handleRemoteAPI(null)
        assertEquals(Response(404), response)
    }

    @Test
    fun `Dersom id er ikke er null, kall callRemoteAPI`() {
        val before = ignoreThis
        handleRemoteAPI(5)
        val after = ignoreThis
        assertEquals(after, before + 1)
    }

    @Test
    fun `Dersom callRemoteAPI returnerer null, returner en respons med status 404`() {
        val response = handleRemoteAPI(2)
        assertEquals(Response(404), response)
    }

    @Test
    fun `Dersom callRemoteAPI returnerer en respons med status 500, kast en exception`() {
        assertThrows<Exception> {
            handleRemoteAPI(1)
        }
    }

    @Test
    fun `Ellers, returner responsen fra callRemoteAPI`() {
        val response = handleRemoteAPI(3)
        assertEquals(Response(200), response)
    }
}