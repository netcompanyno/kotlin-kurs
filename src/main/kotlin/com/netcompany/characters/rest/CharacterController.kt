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
    override fun getAllCharacters(): List<CharacterDto> {
        return characterService.getAllCharacters()
    }

    @GetMapping(path = ["/characters?name={name}"])
    override fun getByName(@PathVariable @RequestParam name: String): CharacterDto {
        return characterService.getByName(name)
    }

    @PostMapping(path = ["/characters"])
    override fun createCharacter(@Valid @RequestBody character: CharacterDto): CharacterDto {
        return characterService.createCharacter(character)
    }

    @GetMapping(path = ["/swapi/characters"])
    override fun getAllCharactersFromStarWarsApi(): List<CharacterDto> {
        return characterService.getAllcharactersFromStarWarsApi()
    }
}
