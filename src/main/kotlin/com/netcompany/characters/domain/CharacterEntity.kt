package com.netcompany.characters.domain

import javax.persistence.*

/**
 * Database representation of a character.
 */
@Entity
data class CharacterEntity(var name: String, var height: Int) {
    // TODO denne virker nok ikke som den skal...
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int = 0

//    @ManyToOne
//    var homeworld: PlanetEntity? = null

    constructor(id: Int, name: String, height: Int) : this(name, height) {
        this.id = id
    }

    constructor() : this("", 0)
}
