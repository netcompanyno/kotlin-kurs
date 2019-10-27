package com.netcompany.characters.service

import com.netcompany.characters.domain.CharacterEntity
import com.netcompany.characters.dto.CharacterDto
import com.netcompany.characters.exception.CharacterNotFoundException
import com.netcompany.characters.repository.CharacterRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CharacterService(val characterRepository: CharacterRepository, val starWarsApiService: StarWarsApiService) {
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
     * Gets the character with the given id.
     *
     * @param id id of the character to be retrieved
     * @return the character with the given id
     * @throws CharacterNotFoundException if no character with given id exists
     */
    fun getById(id: Int): CharacterDto {
        val characterEntity: CharacterEntity = characterRepository.findByIdOrNull(id)
            ?: throw CharacterNotFoundException("Character with id $id not found")

        return CharacterDto(characterEntity)
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

    /**
     * Get all characters from the Star Wars API.
     *
     * @return a list of characters
     */
    fun getCharactersFromStarWarsApi(): List<CharacterDto> {
        return starWarsApiService.getAllCharacters()
    }

    /**
     * Get characters from the Star Wars API with a given name.
     *
     * @return a list containing all the matching characters
     */
    fun getCharactersFromStarWarsApi(name: String): List<CharacterDto> {
        return starWarsApiService.getCharactersByName(name)
    }
}
