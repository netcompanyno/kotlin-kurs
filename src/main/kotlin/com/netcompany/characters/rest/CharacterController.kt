package com.netcompany.characters.rest

import com.netcompany.characters.dto.CharacterDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Oppgave 3
 *
 * Nå returnerer vi en liste av (en enkelt) characters fra endepunktet!
 *
 * Vi ser derimot at initialiseringen av objektet skjer i Controlleren, som egentlig kun skal håndtere ting relatert
 * til selve request og response fra API-et.
 *
 * Derfor ønsker vi å bruke klassen CharacterService i stedet til dette. Flytt initialiseringen dit, og kall denne
 * fra Controlleren.
 *
 * Når du er ferdig kan du kjøre testene CharacterControllerTest og CharacterIT for å se om du har fått det til riktig.
 */
@RestController
class CharacterController {
    @GetMapping(path = ["/hello"])
    fun hello() =  "Hello, Yoda!"

    @GetMapping(path = ["/characters"])
    fun getCharacters(): List<CharacterDto> {
        return listOf(CharacterDto("Yoda", 66, "unknown"))
    }
}
