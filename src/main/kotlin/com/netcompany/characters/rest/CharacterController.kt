package com.netcompany.characters.rest

import com.netcompany.characters.dto.CharacterDto
import com.netcompany.characters.service.CharacterService
import org.springframework.web.bind.annotation.*

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
    override fun getAllCharacters(): kotlin.collections.List<CharacterDto> {
        return characterService.getAllCharacters()
    }

    @GetMapping(path = ["/characters/name/{name}"])
    override fun getByName(@PathVariable name: String): CharacterDto {
        return characterService.getByName(name)
    }
}
