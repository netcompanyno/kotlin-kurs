package com.netcompany.characters.dto

import com.netcompany.characters.domain.CharacterEntity

/**
 * Data transfer object representing a character.
 */
data class CharacterDto(val id: Int, val name: String, val height: Int) {
    constructor(characterEntity: CharacterEntity) : this(characterEntity.id, characterEntity.name, characterEntity.height)
}
