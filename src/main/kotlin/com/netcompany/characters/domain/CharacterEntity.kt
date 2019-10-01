package com.netcompany.characters.domain

import com.netcompany.characters.dto.CharacterDto
import javax.persistence.*

/**
 * Database representation of a character.
 */
@Entity
data class CharacterEntity(var name: String, var height: Int, var homeworld: String) {
    @Id
    @GeneratedValue
    var id: Int = 0

    constructor(id: Int, name: String, height: Int, homeworld: String) : this(name, height, homeworld) {
        this.id = id
    }

    constructor(dto: CharacterDto): this(dto.name, dto.height, dto.homeworld)
}
