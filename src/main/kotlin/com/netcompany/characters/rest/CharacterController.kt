package com.netcompany.characters.rest

import com.netcompany.characters.dto.CharacterDto
import com.netcompany.characters.service.CharacterService
import org.springframework.web.bind.annotation.*

/**
 * Controller that handles REST requests regarding characters.
 */
@RestController
class CharacterController(private val characterService: CharacterService) {
    @GetMapping(path = ["/characters/{id}"])
    fun getById(@PathVariable("id") id: Int): CharacterDto {
        return characterService.getById(id)
    }

    @GetMapping(path = ["/characters"])
    fun getCharacters(@RequestParam(required = false) name: String?): List<CharacterDto> {
        return if (name != null) {
            characterService.getByName(name)
        } else {
            characterService.getAllCharacters()
        }
    }

    @PostMapping(path = ["/characters"])
    fun createCharacter(@RequestBody character: CharacterDto): CharacterDto {
        return characterService.createCharacter(character)
    }

    @GetMapping(path = ["/swapi/characters"])
    fun getCharactersFromStarWarsApi(@RequestParam(required = false) name: String?): List<CharacterDto> {
        return if (name != null) {
            characterService.getCharacterFromStarWarsApiByName(name)
        } else {
            characterService.getAllCharactersFromStarWarsApi()
        }
    }
}
