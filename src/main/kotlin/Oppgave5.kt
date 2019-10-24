/**
 * Oppgave 5
 *
 * I denne oppgaven vil du bli litt mer kjent med scope funksjoner. Oppgaven er helt lik som oppgave 2, men her
 * skal du bruke verken if-else eller when
 *
 * - Dersom id er null, returner en respons med status 404.
 * - Dersom id ikke er null, kall callRemoteAPI
 * - Dersom callRemoteAPI returnerer null, returner en respons med status 404.
 * - Dersom callRemoteAPI returnerer en respons med status 500, kast en exception.
 * - Ellers, returner responsen fra callRemoteAPI.
 *
 * HINT: se takeIf og takeUnless: https://kotlinlang.org/docs/reference/scope-functions.html
 *
 * PS: Det er ikke nødvendigvis lurt å strekke seg så langt for å bruke scope-funksjonene. If-else kan ofte
 * gi bedre lesbarhet.
 */

// Løsningsforslag oppgave 5

fun handleRemoteAPI(id: Int?): Response {
    val response = id?.let(::callRemoteAPI) ?: Response(404)
    return response.takeUnless { it.status == 500 } ?: throw Exception()
}


/*
// -------------- Ikke endre dette --------------

Denne er definert i oppgave 2

data class Response(val status: Int)

var ignoreThis = 0
fun callRemoteAPI(id: Int): Response? {
    ignoreThis++
    return when {
        id % 3 == 0 -> Response(200)
        id % 3 == 1 -> Response(500)
        else -> null
    }
}*/
