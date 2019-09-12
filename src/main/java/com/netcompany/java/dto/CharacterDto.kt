package com.netcompany.java.rest;

import com.netcompany.java.domain.CharacterEntity

/**
 * We provide DTOs that are separate from our domain classes. This is to separate concerns a bit, as sometimes it can
 * be difficult to use the same class for JPA mappings and conversion to json/xml. Also, in many cases you only want a
 * subset of the fields from the entity class in the json result (in our simple example they are the same).
 */
data class ThingDto(val id: Long, val name: String, val location: String) {
    constructor(characterEntity: CharacterEntity) : this(characterEntity.id, characterEntity.name, characterEntity.location)
}
