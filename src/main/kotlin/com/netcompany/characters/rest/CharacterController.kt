package com.netcompany.characters.rest

import com.netcompany.characters.dto.CharacterDto
import com.netcompany.characters.service.CharacterService
import org.springframework.web.bind.annotation.*

/**
 * Oppgave 8
 *
 * Til nå har vi kun operert med våre egendefinerte karakterer. Det finnes derimot også andre tjenester som kan gi oss
 * Star Wars-karakterer, så vi slipper å lage alt selv. En av disse er SWAPI - The Star Wars API - mer informasjon
 * om dette kan finnes på https://swapi.co.
 *
 * Et nytt endepunkt for å hente karakterer herfra er påbegynt nedenfor. Dette skal ha path /swapi/characters. Fullfør
 * metoden her ved å la den kalle tilhørende metode i CharacterService.
 *
 * Når du er ferdig kan du kjøre CharacterIT for å se om du har fått det til.
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

    fun getCharactersFromStarWarsApi() : List<CharacterDto> {
        TODO()
    }
}
