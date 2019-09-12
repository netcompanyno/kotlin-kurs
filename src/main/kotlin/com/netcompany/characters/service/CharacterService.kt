package com.netcompany.characters.service;

import com.netcompany.characters.repository.CharacterRepository;
import com.netcompany.characters.domain.CharacterEntity;
import com.netcompany.characters.exception.CharacterNotFoundException;
import com.netcompany.characters.dto.CharacterDto;
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service for functionality regarding characters.
 */
@Service
open class CharacterService(private val characterRepository: CharacterRepository) {

    /**
     * Gets the character with the given id.
     *
     * @param id id of the character to be retrieved
     * @return the character with the given id
     * @throws CharacterNotFoundException if no character with given id exists
     */
    @Transactional(readOnly = true)
    open fun getById(id: Long): CharacterDto {
        val characterEntity: CharacterEntity = characterRepository.findByIdOrNull(id)
            ?: throw CharacterNotFoundException("CharacterEntity with id $id not found")

        return CharacterDto(characterEntity)
    }

    /**
     * Gets the character with the given name.
     *
     * @param name name of the character to be retrieved
     * @return the character with the given name
     * @throws CharacterNotFoundException if no character with given name exists
     */
    @Transactional(readOnly = true)
    open fun getByName(name: String): CharacterDto {
        return characterRepository.findByName(name)
            .map{t -> CharacterDto(t) }
            .firstOrNull() ?: throw CharacterNotFoundException("CharacterEntity with name $name not found")
    }

    /**
     * Gets all the characters
     *
     * @return a list of characters
     */
    @Transactional(readOnly = true)
    open fun getAllCharacters(): List<CharacterDto> {
        return characterRepository.findAll()
            .map { t -> CharacterDto(t) }
            .toList()
    }
}
