package com.netcompany.characters.domain

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Database representation of a character.
 */
@Entity
data class CharacterEntity(var name: String, var location: String) {
    // TODO denne virker nok ikke som den skal...
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    constructor(id: Long, name: String, location: String) : this(name, location) {
        this.id = id
    }

    constructor() : this("", "")

}
