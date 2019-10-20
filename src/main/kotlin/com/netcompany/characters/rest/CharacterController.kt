package com.netcompany.characters.rest

import com.netcompany.characters.dto.CharacterDto
import com.netcompany.characters.service.CharacterService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Oppgave 5
 *
 * Lag et endepunkt for å opprette karakterer. Dette skal ta imot en karakter, som skal sendes gjennom servicelaget
 * og lagres i databasen. Endepunktet skal retunere den nylig opprettede karakteren.
 *
 * Når du er ferdig skal man kunne opprette en ny karakter fra frontend, og ved å trykke på "Refresh"-knappen skal denne
 * dukke opp i listen. Du kan også kjøre testene for å se om du har løst oppgaven riktig.
 */
@RestController
class CharacterController(val characterService: CharacterService) {
    @GetMapping(path = ["/hello"])
    fun hello() = "Hello, Yoda!"

    @GetMapping(path = ["/characters"])
    fun getCharacters(): List<CharacterDto> {
        return characterService.getCharacters()
    }
}
