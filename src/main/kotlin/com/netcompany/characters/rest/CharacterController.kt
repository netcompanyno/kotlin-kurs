package com.netcompany.characters.rest

import com.netcompany.characters.dto.CharacterDto
import com.netcompany.characters.service.CharacterService
import org.springframework.web.bind.annotation.*

/**
 * Oppgave 10
 *
 * Vi ønsker nå å implementere et enkelt søk i karakterene som hentes fra SWAPI. Utvid endepunktet GET /swapi/characters
 * til å ta inn en optional parameter name. Kall riktig metode i CharacterService basert på om denne er null eller ikke.
 *
 * Når du har implementert endepunktet ferdig kan du kjøre CharacterIT.
 */
@RestController
class CharacterController(val characterService: CharacterService) {
    @GetMapping(path = ["/hello"])
    fun hello() = "Hello, Yoda!"

    @GetMapping(path = ["/characters"])
    fun getCharacters(): List<CharacterDto> {
        return characterService.getCharacters()
    }

    @GetMapping(path = ["/characters/{id}"])
    fun getById(@PathVariable("id") id: Int): CharacterDto {
        return characterService.getById(id)
    }

    @PostMapping(path = ["/characters"])
    fun createCharacter(@RequestBody characterDto: CharacterDto): CharacterDto {
        return characterService.createCharacter(characterDto)
    }

    @GetMapping(path = ["/swapi/characters"])
    fun getCharactersFromStarWarsApi() : List<CharacterDto> {
        return characterService.getCharactersFromStarWarsApi()
    }
}
