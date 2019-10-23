import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class Oppgave6Test {

    @Test
    fun `Submit fra LoggedOut skal gå til Loading ved færre enn 5 attempts`() {
        for (attempts in 0..4) {
            val nextState = LoggedOut(attempts)
                .nextState(Submit("username", "password"))

            assertEquals(Loading(attempts), nextState)
        }
    }

    @Test
    fun `Submit fra LoggedOut skal gå til LoggedOut med riktig reason ved 5 eller fler attempts`() {
        for (attempts in 5..10) {
            val nextState = LoggedOut(attempts)
                .nextState(Submit("username", "password"))

            assertEquals(LoggedOut(attempts + 1, Reason.TooManyTries), nextState)
        }
    }

    @Test
    fun `Error fra LoggedOut skal kaste IllegalStateException`() {
        assertThrows<IllegalStateException> {
            LoggedOut().nextState(Error(Reason.WrongPassword))
        }
    }

    @Test
    fun `Success fra LoggedOut skal kaste IllegalStateException`() {
        assertThrows<IllegalStateException> {
            LoggedOut().nextState(Success("userdata"))
        }
    }

    @Test
    fun `Logout fra LoggedOut skal kaste IllegalStateException`() {
        assertThrows<IllegalStateException> {
            LoggedOut().nextState(Logout)
        }
    }

    @Test
    fun `Success fra Loading skal gå til LoggedIn`() {
        for (attempts in 0..10) {
            val nextState = Loading(attempts)
                .nextState(Success("userdata"))

            assertEquals(LoggedIn("userdata"), nextState)
        }
    }

    @Test
    fun `Error fra Loading skal gå til LoggedOut med attempts økt med 1 og riktig reason`() {
        for (attempts in 0..10) {
            val nextState = Loading(attempts)
                .nextState(Error(Reason.WrongPassword))

            assertEquals(LoggedOut(attempts + 1, Reason.WrongPassword), nextState)
        }
    }

    @Test
    fun `Submit fra Loading skal kaste IllegalStateException`() {
        assertThrows<IllegalStateException> {
            Loading(0).nextState(Submit("username", "password"))
        }
    }

    @Test
    fun `Logout fra Loading skal kaste IllegalStateException`() {
        assertThrows<IllegalStateException> {
            Loading(0).nextState(Logout)
        }
    }

    @Test
    fun `Logout fra LoggedIn skal gå til LoggedOut`() {
        for (attempts in 0..10) {
            val nextState = LoggedIn("userdata")
                .nextState(Logout)

            assertEquals(LoggedOut(0, null), nextState)
        }
    }

    @Test
    fun `Submit fra LoggedIn skal kaste IllegalStateException`() {
        assertThrows<IllegalStateException> {
            LoggedIn("userdata").nextState(Submit("username", "password"))
        }
    }

    @Test
    fun `Error fra LoggedIn skal kaste IllegalStateException`() {
        assertThrows<IllegalStateException> {
            LoggedIn("userdata").nextState(Error(Reason.WrongPassword))
        }
    }

    @Test
    fun `Success fra LoggedIn skal kaste IllegalStateException`() {
        assertThrows<IllegalStateException> {
            LoggedIn("userdata").nextState(Success("userdata"))
        }
    }

}