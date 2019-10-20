package com.netcompany.characters.rest

import com.netcompany.characters.dto.CharacterDto
import com.netcompany.characters.service.CharacterService
import org.springframework.web.bind.annotation.*

/**
 * Oppgave 6
 *
 * Lag et endepunkt som henter karakter basert på id. Merk at vi foreløpig kun har feltet id i CharacterEntity, men
 * siden vi nå skal bruke det i kall som gjøres utenfra, trenger vi å legge det til også i CharacterDto.
 *
 * Når du har løst oppgaven skal man fra frontend kunne hente ut en eksisterende karakter basert på id.
 * Du kan også kjøre testene.
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
}
