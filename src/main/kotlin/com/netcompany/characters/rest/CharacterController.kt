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

    @GetMapping(path = ["/characters"], params = ["name"])
    override fun getByName(@RequestParam(required = true) name: String): CharacterDto {
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

    @GetMapping(path = ["/swapi/characters"], params = ["name"])
    override fun getCharacterFromStarWarsApiByName(@RequestParam(required = true) name: String): List<CharacterDto> {
        return characterService.getCharacterFromStarWarsApiByName(name)
    }
}
