package com.netcompany.characters.rest

import com.netcompany.characters.dto.CharacterDto
import com.netcompany.characters.service.CharacterService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

/**
 * Controller that handles REST requests regarding characters.
 */
@RestController
class CharacterController(private val characterService: CharacterService) : CharacterApi {
    @GetMapping(path = ["/characters/{id}"])
    override fun getById(@PathVariable("id") id: Int): CharacterDto {
        return characterService.getById(id)
    }

    @GetMapping(path = ["/characters"])
    override fun getCharacters(@RequestParam(required = false) name: String?): List<CharacterDto> {
        return if (name != null) {
            characterService.getByName(name)
        } else {
            characterService.getAllCharacters()
        }
    }

    @PostMapping(path = ["/characters"])
    override fun createCharacter(@Valid @RequestBody character: CharacterDto): CharacterDto {
        return characterService.createCharacter(character)
    }

    @GetMapping(path = ["/swapi/characters"])
    override fun getCharactersFromStarWarsApi(@RequestParam(required = false) name: String?): List<CharacterDto> {
        return if (name != null) {
            characterService.getCharacterFromStarWarsApiByName(name)
        } else {
            characterService.getAllcharactersFromStarWarsApi()
        }
    }
}
