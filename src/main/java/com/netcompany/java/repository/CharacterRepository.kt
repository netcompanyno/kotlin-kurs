package com.netcompany.java.repository;

import com.netcompany.java.domain.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repository for characters..
 */
@Transactional
interface CharacterRepository : JpaRepository<CharacterEntity, Long> {

    /**
     * Finds a character by name.
     *
     * @param name the name of the character we want to get
     * @return the character
     */
    fun findByName(name: String): List<CharacterEntity>
}
