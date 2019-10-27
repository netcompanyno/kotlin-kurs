package com.netcompany.characters.rest

import com.netcompany.characters.dto.CharacterDto
import com.netcompany.characters.service.CharacterService
import org.springframework.web.bind.annotation.*

/**
 * Oppgave 11
 *
 * Oppgave 10 var siste Spring Boot-oppgave! Hvis du er ferdig og har mer tid igjen, finnes det nye Kotlin-oppgaver i
 * branchene kotlin-oppgave-5, kotlin-oppgave-6 og kotlin-oppgave-7.
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
    fun getCharactersFromStarWarsApi(@RequestParam(required = false) name: String?) : List<CharacterDto> {
        return if (name == null) {
            characterService.getCharactersFromStarWarsApi()
        } else {
            characterService.getCharactersFromStarWarsApi(name)
        }
    }
}
