package com.netcompany.characters.rest

import com.netcompany.characters.dto.CharacterDto
import com.netcompany.characters.service.CharacterService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class CharacterController(val characterService: CharacterService) {
    @GetMapping(path = ["/hello"])
    fun hello() = "Hello, Yoda!"

    @GetMapping(path = ["/characters"])
    fun getCharacters(): List<CharacterDto> {
        return characterService.getCharacters()
    }
}
