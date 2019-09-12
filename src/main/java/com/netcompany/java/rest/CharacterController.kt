package com.netcompany.java.rest;

import com.netcompany.java.dto.CharacterDto
import com.netcompany.java.service.CharacterService;
import org.springframework.web.bind.annotation.*

/**
 * Controller that handles REST requests regarding characters.
 */
@RestController
class CharacterController(private val characterService: CharacterService) : CharacterApi {
    @GetMapping(path = ["/characters/{id}"])
    override fun getById(@PathVariable("id") id: Long): CharacterDto {
        return characterService.getById(id)
    }

    @GetMapping(path = ["/characters"])
    override fun getAllCharacters(): kotlin.collections.List<CharacterDto> {
        return characterService.getAllCharacters()
    }

    @GetMapping(path = ["/characters/name/{name}"])
    override fun getByName(name: String): CharacterDto {
        return characterService.getByName(name)
    }
}
