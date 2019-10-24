/**
 * Oppgave 6
 *
 * Sealed classes er et kraftig verktøy som kan brukes til mye.
 * I presentasjonen så vi at man kan bruke sealed classes til å lage et lite "språk"
 * som ble evaluert i en "Expression.evaluate" funksjon.
 *
 * I denne oppgaven skal vi bruke sealed classes til å modellere en tilstandsmaskin.
 * Tilstandsmaskinen brukes her i en login-kontekst. Funksjonen "nextState" finner ut hvilken tilstand man skal
 * gå inn i basert på nåværende tilstand og en hendelse.
 * Skriv funksjonen "nextState" etter følgende krav:
 *
 * I tilstanden "LoggedOut" kan man motta en "Submit" action. Dersom antall innloggingsforsøk er 5 eller mer,
 * så skal man forbli i "LoggedOut"-tilstanden, men med oppdatert "reason" og "attempts".
 * Dersom antall innloggingsforsøk er færre enn 5, så skal man gå til tilstanden "Loading".
 *
 * I tilstanden "Loading" kan man motta en "Error" eller en "Success" action. Ved "Error" går man tilbake til
 * "LoggedOut"-tilstanden, med "attempts" økt med 1 og riktig "reason".
 * Ved "Success" går man til "LoggedIn"-tilstanden med tilsvarende "userdata".
 *
 * I tilstanden "LoggedIn" kan man motta en "Logout" action. Da går man til "LoggedOut".
 *
 * Alle actions som er ulovlige i tilstanden man er i skal kaste en IllegalArgumentException.
 *
 * Testene i Oppgave6Test vil kjøre grønt når funksjonen er implementert riktig.
 */

enum class Reason {
    WrongPassword,
    TooManyTries
}

sealed class State

data class LoggedOut(val attempts: Int = 0, val reason: Reason? = null) : State()
data class Loading(val attempts: Int) : State()
data class LoggedIn(val userdata: String) : State()

sealed class Action

data class Submit(val username: String, val password: String) : Action()
data class Error(val reason: Reason) : Action()
data class Success(val userdata: String) : Action()
object Logout : Action()


fun State.nextState(action: Action): State = TODO("Skriv denne funksjonen etter kravene i beskrivelsen.")