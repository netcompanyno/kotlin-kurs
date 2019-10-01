package com.netcompany.characters.service

import com.netcompany.characters.dto.CharacterDto
import org.springframework.stereotype.Service

/**
 * Service for functionality regarding characters.
 */
@Service
class CharacterService {
    /**
     * Gets all the characters.
     *
     * @return a list of characters
     */
    fun getCharacters(): List<CharacterDto> {
        return listOf(CharacterDto("Yoda", 66, "unknown"))
    }
}
