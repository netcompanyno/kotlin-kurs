import java.lang.Exception

/**
 * Oppgave 2
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

fun handleRemoteCall(id: Int?): Response  {
    if (id == null) {
        return Response(404)
    }

    val response = callRemoteAPI(id)

    return when (response) {
        null -> Response(404)
        Response(500) -> throw Exception()
        else -> response
    }
}



// Ikke endre dette --------------
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