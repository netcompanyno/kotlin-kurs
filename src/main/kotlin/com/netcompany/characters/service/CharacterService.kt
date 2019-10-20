package com.netcompany.characters.service

import com.netcompany.characters.domain.CharacterEntity
import com.netcompany.characters.dto.CharacterDto
import com.netcompany.characters.exception.CharacterNotFoundException
import com.netcompany.characters.repository.CharacterRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

/**
 * Oppgave 6
 *
 * Lag en metode som henter en karakter basert på id.
 * Hvis karakteren ikke finnes skal det kastes en CharacterNotFoundException.
 *
 * Tips: JpaRepository har en metode findByIdOrNull.
 */
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

    /**
     * Creates a character.
     *
     * @param characterDto dto representing the character
     * @return dto representing the newly created character
     */
    fun createCharacter(characterDto: CharacterDto): CharacterDto {
        val characterEntity = CharacterEntity(characterDto)

        return CharacterDto(characterRepository.save(characterEntity))
    }
}
