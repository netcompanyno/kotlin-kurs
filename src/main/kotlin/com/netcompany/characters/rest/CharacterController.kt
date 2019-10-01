package com.netcompany.characters.rest

import com.netcompany.characters.dto.CharacterDto
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Oppgave 2
 *
 * I oppgave 1 returnerte endepunktet vårt kun en tekststreng.
 *
 * Vi skal nå lage et endepunkt som returnerer en faktisk character i stedet.
 *
 * Først må vi lage et objekt som representerer en character. Dette er påbegynt i filen CharacterDto.kt.
 * Åpne filen og ferdigstill det før du kommer tilbake hit.
 *
 * Funksjonen for endepunktet er påbegynt under. Pathen skal være /characters, og siden vi senere skal kunne hente ut
 * flere av gangen, velger vi å la endepunktet returnere en liste.
 *
 * Opprett en ny fritt valgt CharacterDto i metoden under og la endepunktet returnere denne.
 *
 * Når du er ferdig kan du kjøre testene i CharacterIT for å se om du har fått det til riktig.
 *
 */
@RestController
class CharacterController {
    @GetMapping(path = ["/hello"])
    fun hello() =  "Hello, Yoda!"

    fun getCharacters(): List<CharacterDto> {
        return emptyList()
    }
}
