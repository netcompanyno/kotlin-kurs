package com.netcompany.java.service;

import com.netcompany.java.repository.CharacterRepository;
import com.netcompany.java.domain.CharacterEntity;
import com.netcompany.java.exception.CharacterNotFoundException;
import com.netcompany.java.rest.ThingDto;
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service for functionality regarding {@link CharacterEntity}.
 */
@Service
open class ThingService(val characterRepository: CharacterRepository) {

    /**
     * Gets a {@link CharacterEntity} with the given id.
     *
     * @param id id of the thing to be retrieved
     * @return a {@link CharacterEntity} with the given id
     * @throws CharacterNotFoundException if no {@link CharacterEntity} with given id exists
     */
    @Transactional(readOnly = true)
    open fun getById(id: Long): ThingDto {
        val characterEntity: CharacterEntity = characterRepository.findByIdOrNull(id)
            ?: throw CharacterNotFoundException("CharacterEntity with id $id not found")

        return ThingDto(characterEntity)
    }

    /**
     * Gets all the {@link CharacterEntity things}!
     *
     * @return a list of {@link CharacterEntity things}
     */

    @Transactional(readOnly = true)
    open fun getAllThings(): List<ThingDto> {
        return characterRepository.findAll()
            .map { t -> ThingDto(t) }
            .toList()
    }

    /**
     * Get all {@link CharacterEntity things} with the given name.
     *
     * @param name name of the things to be retrieved
     * @return a list of {@link CharacterEntity things}
     */
    @Transactional(readOnly = true)
    open fun getByName(name: String): ThingDto {
        return characterRepository.findByName(name)
            .map{t -> ThingDto(t)}
            .firstOrNull() ?: throw CharacterNotFoundException("CharacterEntity with name $name not found")
    }
}
