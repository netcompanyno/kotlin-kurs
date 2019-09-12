package com.netcompany.java.dto;

import com.netcompany.java.domain.CharacterEntity

/**
 * Data transfer object representing a character.
 */
data class CharacterDto(val id: Long, val name: String, val location: String) {
    constructor(characterEntity: CharacterEntity) : this(characterEntity.id, characterEntity.name, characterEntity.location)
}
