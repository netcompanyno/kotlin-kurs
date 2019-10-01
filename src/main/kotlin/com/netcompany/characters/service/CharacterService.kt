package com.netcompany.characters.service

import com.netcompany.characters.dto.CharacterDto
import com.netcompany.characters.repository.CharacterRepository
import org.springframework.stereotype.Service

@Service
class CharacterService(val characterRepository: CharacterRepository) {
    /**
     * Gets all the characters.
     *
     * @return a list of characters
     */
    fun getCharacters(): List<CharacterDto> {
        return characterRepository.findAll()
            .map { c -> CharacterDto(c) }
            .toList()
    }
}
