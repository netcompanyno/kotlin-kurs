package com.netcompany.characters.repository

import com.netcompany.characters.domain.CharacterEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.transaction.annotation.Transactional

/**
 * Repository for characters..
 */
@Transactional
interface CharacterRepository : JpaRepository<CharacterEntity, Int> {

    /**
     * Finds a character by name.
     *
     * @param name the name of the character we want to get
     * @return the character
     */
    fun findByName(name: String): List<CharacterEntity>
}
