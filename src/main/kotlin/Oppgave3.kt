import kotlin.random.Random

/**
 * Oppgave 3
 *
 * I denne oppgaven vil du bli litt mer kjent med hvordan null-safety og smart casting
 * fungerer i Kotlin.
 * Skriv funksjonen handleRemoteCall etter følgende krav, og få testene i Oppgave3Test til å kjøre grønt.
 *
 * - Dersom id er null, returner en respons med status 404.
 * - Dersom id ikke er null, kall callRemoteAPI
 * - Dersom callRemoteAPI returnerer null, returner en respons med status 404.
 * - Dersom callRemoteAPI returnerer en respons med status 500, kast en exception.
 * - Ellers, returner responsen fra callRemoteAPI.
 */

// Løsningsforslag oppgave 3

fun handleRemoteCall(id: Int?): Response {
    if (id == null) {
        return Response(404)
    }

    // Her har id blitt smart castet fra Int? til Int.
    val response = callRemoteAPI(id)

    return when (response?.status) {
        500 -> throw RuntimeException("Status var 500")
        null -> Response(404)
        else -> response // Smart cast fra Response? til Response
    }
}


// -------------- Ikke endre dette --------------
data class Response(val status: Int)

var ignoreThis = 0
fun callRemoteAPI(id: Int): Response? {
    ignoreThis++
    return when {
        id % 3 == 0 -> Response(200)
        id % 3 == 1 -> Response(500)
        else -> null
    }
}