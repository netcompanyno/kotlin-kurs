package com.netcompany.characters.domain

import com.netcompany.characters.dto.CharacterDto
import javax.persistence.*

/**
 * Database representation of a character.
 */
@Entity
data class CharacterEntity(var name: String, var height: Int, var homeworld: String) {
    // TODO denne virker nok ikke som den skal...
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int = 0

    constructor(id: Int, name: String, height: Int, homeworld: String) : this(name, height, homeworld) {
        this.id = id
    }

    @Deprecated("")
    constructor() : this("", 0, "")

    constructor(characterDto: CharacterDto): this(characterDto.name, characterDto.height, characterDto.homeworld)
}
