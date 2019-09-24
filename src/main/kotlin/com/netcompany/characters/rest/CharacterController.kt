package com.netcompany.characters.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Oppgave 1
 *
 * Lag et endepunkt med path /hello, som returnerer tekststrengen "Hello, Yoda!".
 *
 * Applikasjonen kjøres ved å kjøre `mvn spring-boot:run` fra en terminal eller ved å kjøre klassen Application fra IDE.
 *
 * Etter å ha startet opp applikasjonen kan du kunne åpne http://localhost:5000/api/hello i en nettleser.
 * Om du har fått til oppgaven skal da teksten "Hello, Yoda!" vises.
 *
 * Etter å ha gjort oppgaven kan du åpne klassen CharacterIT og kjøre testen der for å se om du har fått det til.
 */
@RestController
class CharacterController {
    @GetMapping(path = ["/hello"])
    fun hello() =  "Hello, Yoda!"
}
